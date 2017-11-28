package com.smu.mkdocer.parser.finder

import com.smu.mkdocer.data.Language
import com.smu.mkdocer.data.Type
import com.smu.mkdocer.data.getDocType

sealed class DeclarationHelper {
    protected var _commentDeclaration = StringBuilder()

    val commentDeclaration: String
        get() = _commentDeclaration.toString()

    open fun clear() {
        _commentDeclaration = StringBuilder()
    }

    abstract fun prepareCommentDeclaration(line: String): Boolean?
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

class ObjectiveCDeclarationHelper : DeclarationHelper() {

    private var docType: Type? = null

    override fun prepareCommentDeclaration(line: String): Boolean? {
        if (docType == null) {
            docType = line.getDocType(Language.OBJECTIVE_C)
        } else {
            val docType = line.getDocType(Language.OBJECTIVE_C)
            if (docType != null) {
                this.docType = null
                return false
            }
        }

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
        if (end != null || docType == Type.CLASS) {
            docType = null
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
