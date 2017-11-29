package com.smu.mkdocer.parser.finder

import com.smu.mkdocer.data.Language

class DocFinder(language: Language) {

    private val declarationHelper: DeclarationHelper = when (language) {
        Language.JAVA -> JavaDeclarationHelper()
        Language.KOTLIN -> KotlinDeclarationHelper()
        Language.OBJECTIVE_C -> ObjectiveCDeclarationHelper()
    }

    private var isCommentBody = false
    private var isSingleCommentBody = false

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
        isSingleCommentBody = trimLine.startsWith("//!")

        if (isCommentBody || isSingleCommentBody) {
            if (_commentBody.isNotEmpty()) {
                _commentBody.append("\n")
            }
            _commentBody.append(transformLine(trimLine))
        }

        if (trimLine.endsWith("*/")) {
            isCommentBody = false
            return null
        }

        if (!(isCommentBody || isSingleCommentBody) && _commentBody.isNotEmpty()) {
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
        result = result.removePrefix("//!")
        return result
    }
}