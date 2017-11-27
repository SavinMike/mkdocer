package com.smu.mkdocer.template

interface Template {
    fun mapDeclaration(declaration: String?): String

    fun mapDescription(description: String?): String

    fun mapParams(params: Map<String, String>?): String

    fun mapVersion(value: List<String>?): String

    fun mapAuthor(value: List<String>?): String

    fun mapReturnParams(value: String?): String

    fun mapExceptions(value: List<String>?): String

    fun mapDeprecated(value: List<String>?): String

}