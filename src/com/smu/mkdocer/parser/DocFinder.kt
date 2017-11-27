package com.smu.mkdocer.parser

import com.smu.mkdocer.data.Language
import com.smu.mkdocer.data.Type
import com.smu.mkdocer.data.getDocType

class DocFinder(language: Language) {

    private val declarationHelper: DeclarationHelper = when (language) {
        Language.JAVA -> JavaDeclarationHelper()
        Language.KOTLIN -> KotlinDeclarationHelper()
        Language.OBJECTIVE_C -> TODO()
    }

    private var isCommentBody = false

    private var _commentBody = StringBuilder()
    val commentBody: String
        get() = _commentBody.toString()

    private var isCommentDeclaration = false
    val commentDeclaration: String
        get() = declarationHelper.commentDeclaration

    fun findComment(line: String): Boolean? {
        val trimLine = line.trim()
        if (trimLine.startsWith("/**")) {
            isCommentBody = true
        }

        if (isCommentBody) {
            if (_commentBody.isNotEmpty()) {
                _commentBody.append("\n")
            }
            _commentBody.append(transformLine(trimLine))
        }

        if (trimLine.endsWith("*/")) {
            isCommentBody = false
            return null
        }

        if (!isCommentBody && _commentBody.isNotEmpty()) {
            isCommentDeclaration = true
        }

        if (isCommentDeclaration) {
            val prepareCommentDeclaration = declarationHelper.prepareCommentDeclaration(trimLine)
            if (prepareCommentDeclaration == true) {
                isCommentDeclaration = false
                return true
            } else if (prepareCommentDeclaration == false) {
                isCommentDeclaration = false
                findComment(line)
                return true
            }
        }

        return null
    }

    fun clear() {
        _commentBody = StringBuilder()
        declarationHelper.clear()
    }

    private fun transformLine(line: String): String {
        var result = line.trim()
        result = result.removePrefix("/**")
        result = result.removePrefix("/*")
        result = result.removePrefix("*/")
        result = result.removePrefix("*")
        return result
    }
}

class KotlinDeclarationHelper : DeclarationHelper() {

    private var startSymbol: Symbol? = null
    private var docType: Type? = null

    override fun prepareCommentDeclaration(line: String): Boolean? {
        if (docType == null) {
            docType = line.getDocType(Language.KOTLIN)
        } else {
            val docType = line.getDocType(Language.KOTLIN)
            if (docType != null) {
                clean()
                return false
            }
        }

        if (docType != null) {
            if (line.trim().startsWith("@")) {
                clean()
                return false
            } else if (line.trim().startsWith("/**")) {
                clean()
                return false
            }
        }

        if (_commentDeclaration.isNotEmpty() && line.isNotEmpty()) {
            _commentDeclaration.append("\n")
        }

        if (startSymbol == null) {
            startSymbol = when {
                line.contains("(") -> Symbol.Bracket()
                line.contains("{") -> Symbol.CurlyBracket()
                else -> null
            }
        }

        startSymbol?.apply {
            count += (line.split(symbol).size - 1)
            if (oppositeSymbol != null) {
                count -= (line.split(oppositeSymbol).size - 1)
            }
        }

        val isSuccess = if (docType == Type.PROPERTY && startSymbol == null && line.contains("=")) true else startSymbol?.isSuccess()
        if (isSuccess != false) {
            _commentDeclaration.append(line.trim().removeSuffix("{"))
        }

        if (isSuccess != null) {
            clean()
        }
        return isSuccess
    }

    private fun clean() {
        docType = null
        startSymbol = null
    }

    private sealed class Symbol(val symbol: String,
                                val oppositeSymbol: String? = null) {
        var count: Int = 0

        abstract fun isSuccess(): Boolean?

        class Bracket : Symbol("(", ")") {
            override fun isSuccess(): Boolean? = count == 0
        }

        class CurlyBracket : Symbol("{", "}") {
            override fun isSuccess(): Boolean? = count == 1
        }

        class CommentSymbol : Symbol("/**", "*/") {
            override fun isSuccess(): Boolean? = false
        }

    }
}

class JavaDeclarationHelper : DeclarationHelper() {

    override fun prepareCommentDeclaration(line: String): Boolean? {
        val declarationEnd = arrayListOf("{", ";")
        val first = declarationEnd.firstOrNull { line.startsWith(it) }
        if (first != null) {
            return true
        }

        if (_commentDeclaration.isNotEmpty()) {
            _commentDeclaration.append("\n")
        }
        _commentDeclaration.append(transformDeclarationLine(line, declarationEnd))

        val end = declarationEnd.firstOrNull { line.endsWith(it) }
        if (end != null) {
            return true
        }
        return null
    }

    private fun transformDeclarationLine(line: String,
                                         declarationEnd: ArrayList<String> = arrayListOf()): String {
        var result = line.trim()
        declarationEnd.forEach { result = result.removeSuffix(it) }
        return result
    }
}

sealed class DeclarationHelper {
    protected var _commentDeclaration = StringBuilder()

    val commentDeclaration: String
        get() = _commentDeclaration.toString()

    open fun clear() {
        _commentDeclaration = StringBuilder()
    }

    abstract fun prepareCommentDeclaration(line: String): Boolean?
}