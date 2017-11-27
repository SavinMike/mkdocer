package com.smu.mkdocer.template

import com.smu.mkdocer.data.StringParam

interface Escaper {
    fun escape(docString: String): String
}

class CompositeEscaper(private val escaper: Array<Escaper>) : Escaper {
    override fun escape(docString: String): String {
        var result = docString
        escaper.forEach { result = it.escape(result) }
        return result
    }
}

class BrEscaper : Escaper {
    override fun escape(docString: String): String {
        var result = docString
        result = Regex("<br>").replace(result, "\n")
        return result
    }
}

abstract class HtmlBlockEscaper(private val name: String = "") : Escaper {

    protected open val regex: Regex
        get() = Regex("<$name>((.*?(\\n))+.*?)(<$name/>|</$name>)")

    fun escape(docString: String, callback: (MatchResult, String) -> String): String {
        var result = docString
        regex.findAll(result).forEach {
            result = callback(it, result)
        }

        return result
    }
}

class PreEscaper : HtmlBlockEscaper("pre") {
    override fun escape(docString: String): String {
        return escape(docString, { matcher, string ->
            string.replace(matcher.groupValues[0], matcher.groupValues[1])
        })
    }
}

class CodeEscaper : HtmlBlockEscaper("code") {
    override fun escape(docString: String): String {
        return escape(docString, { matchResult, string ->
            string.replace(matchResult.groupValues[0], matchResult.groupValues[1].codeBlock())
        })
    }
}

class LinkEscaper : HtmlBlockEscaper("a") {
    override val regex: Regex
        get() = Regex("<a\\s*href=\"(.*)\".*>(.*)(<a/>|</a>)")

    override fun escape(docString: String): String {
        return escape(docString, { matchResult, result ->
            result.replace(matchResult.groupValues[0], matchResult.groupValues[2].toLink(matchResult.groupValues[1]))
        })
    }
}

class LinkParam : StringParam(), Escaper {
    override fun escape(docString: String): String {
        return replaceData(docString, obtainData(docString))
    }

    override fun obtainData(docString: String): String? {
        val obtainData = super.obtainData(docString)

        if (obtainData?.contains("com.pushwoosh.") == true) {
            val find = Regex("com.pushwoosh.([\\w\\d.]+)(\\s+|#)(.*)").find(obtainData)
            return find?.groupValues?.get(3)?.toLink(find.groupValues[1].createLink() + ".md")
        }

        return obtainData?.toLink(obtainData.createLink())
    }

    override fun regex(value: String): Regex {
        return Regex("\\{@$value\\s+([^}]+)}")
    }

    override val _name: Array<String>
        get() = arrayOf("link")
}