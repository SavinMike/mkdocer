package com.smu.mkdocer.data

import com.smu.mkdocer.template.codeBlock
import com.smu.mkdocer.template.createLink
import com.smu.mkdocer.template.toLink

sealed class DocParam<out T> {
    abstract val name: Array<String>

    abstract fun obtainData(docString: String): T

    protected fun obtainData(docString: String, callback: (String) -> Unit) {
        name.forEach {
            if (!docString.contains("@$it")) {
                return
            }

            val findAll = regex(it).findAll(docString)
            findAll.forEach {
                callback(it.groupValues[regexGroupId()])
            }
        }
    }

    protected open fun regexGroupId() = 1
    protected open fun regex(value: String) = Regex("@$value\\s+(.*)(\n)")

    fun removeFromString(docString: String): String {
        var result: String = docString
        name.forEach {
            result = regex(it).replace(result, "")
        }
        return result
    }

    fun replaceData(docString: String, replacedData: Any?): String {
        var result: String = docString
        name.forEach {
            val replace = replacedData?.toString() ?: ""
            result = regex(it).replace(result, replace)
        }
        return result
    }
}

class CodeParam : StringParam() {

    override fun obtainData(docString: String): String? {
        return super.obtainData(docString)?.codeBlock("java")
    }

    override fun regex(value: String): Regex {
        return Regex("\\{@code\n((.*?(\\n))+.*?)}")
    }

    override val _name: Array<String>
        get() = arrayOf("code")
}

class SeeParam : StringParam() {

    override val _name: Array<String>
        get() = arrayOf("see")
}

abstract class StringParam : DocParam<String?>() {

    override val name: Array<String>
        get() = _name

    abstract val _name: Array<String>

    override fun obtainData(docString: String): String? {
        var result: String? = null
        obtainData(docString, {
            result = it
        })

        return result
    }
}

class Params : DocParam<Map<String, String>>() {

    override val name: Array<String> = arrayOf("param")

    override fun obtainData(docString: String): Map<String, String> {
        val result = mutableMapOf<String, String>()
        obtainData(docString, {
            Regex("\\s*([\\w\\d]+)\\s+(.*)").find(it)
                    ?.takeIf { it.groupValues.size >= 3 }
                    ?.let {
                        result.put(it.groupValues[1], it.groupValues[2])
                    }
        })

        return result
    }

}

class Author : DocParam<List<String>>() {

    override fun obtainData(docString: String): List<String> {
        val result = mutableListOf<String>()
        obtainData(docString, {
            Regex("\\s+(.*)").find(it)
                    ?.takeIf { it.groupValues.size >= 2 }
                    ?.let {
                        result.add(it.groupValues[1])
                    }
        })
        return result
    }

    override val name: Array<String>
        get() = arrayOf("author")


}

class Version : StringParam() {
    override val _name: Array<String>
        get() = arrayOf("version")
}

class Return : StringParam() {
    override val _name: Array<String>
        get() = arrayOf("return")
}

class Throws : DocParam<List<String>>() {

    override fun obtainData(docString: String): List<String> {
        val result = mutableListOf<String>()
        obtainData(docString, {
            Regex("\\s+(.*)").find(it)
                    ?.takeIf { it.groupValues.size >= 2 }
                    ?.let {
                        result.add(it.groupValues[1])
                    }
        })
        return result
    }

    override val name: Array<String>
        get() = arrayOf("throws", "exceptions")
}

class Deprecated : StringParam() {
    override val _name: Array<String>
        get() = arrayOf("deprecated")
}