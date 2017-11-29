package com.smu.mkdocer.template

import com.smu.mkdocer.data.Language

class MarkDownTemplate : Template {
    override fun mapParams(params: Map<String, String>?): String {
        val builder = StringBuilder()
        params?.entries
                ?.forEach { builder.append(it.value.toKeyList(it.key)).append("\n") }

        return builder.toString()
    }

    override fun mapVersion(value: List<String>?): String = value?.first()?.escapeToMarkdown() ?: ""

    override fun mapAuthor(value: List<String>?): String = value?.first()?.escapeToMarkdown() ?: ""

    override fun mapReturnParams(value: String?): String = value?.toKeyList("Return Value") ?: ""

    override fun mapExceptions(value: List<String>?): String = value?.toString()?.escapeToMarkdown()?.toSimpleList() ?: ""

    override fun mapDeprecated(value: List<String>?): String = "DEPRECATED: $value"

    override fun mapDeclaration(declaration: String?) = declaration?.codeBlock() ?: ""

    override fun mapDescription(description: String?) = description?.escapeToMarkdown() ?: ""
}

fun Language.getMarkdownCode() = when (this) {
    Language.JAVA -> "java"
    Language.KOTLIN -> "kotlin"
    Language.OBJECTIVE_C -> "objC"
}

fun String.toKeyList(key: String) = "* ${key.toBold()} - ${this.escapeToMarkdown()}"
fun String.toSimpleList() = "* $this"
fun String.codeBlock(type: String = "") = "```$type\n${this}\n```"
fun String.toBold() = "**$this**"
fun String.toLink(linkAddress: String) = "[$this](" +
        "${linkAddress.replace(
                Regex("^([\\w\\d]+)#(.*)"),
                { "${it.groupValues[1]}.md#${it.groupValues[2].createLink()}" })
                .replace(
                        Regex("^#(.*)"),
                        { "#${it.groupValues[1].createLink()}" })
        })"

fun String.createLink() = this.replace(Regex("\\s+"), "").replace(".", "/")


fun divider() = "---"

fun String.escapeToMarkdown(): String {
    val escaper = CompositeEscaper(
            arrayOf(PreEscaper(),
                    CodeEscaper(),
                    BrEscaper(),
                    LinkParam(),
                    LinkEscaper()))
    return escaper.escape(this)
}

