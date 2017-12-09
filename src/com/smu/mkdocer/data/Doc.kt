package com.smu.mkdocer.data

sealed class Doc(val declaration: String,
                 val type: Type,
                 val description: String? = null,
                 val params: Map<String, String>? = null,
                 val version: String? = null,
                 val author: List<String>? = null,
                 val returnParams: String? = null,
                 val exceptions: List<String>? = null,
                 val deprecated: String? = null,
                 val language: Language) {
    val name: String
        get() {
            val pattern = type.pattern(language)
            val matcher = pattern?.first?.find(declaration)
            return if (matcher != null) {
                provideNameByType(type, pattern, matcher)
            } else {
                ""
            }
        }

    protected open fun provideNameByType(type: Type, pattern: Pair<Regex, Int>, matcher: MatchResult): String = when (type) {
        Type.METHOD -> "${matcher.groupValues[pattern.second]}(${generateMethodNameFromParams(matcher.groupValues[pattern.second + 1])})"
        else -> matcher.groupValues[pattern.second]
    }

    protected abstract fun generateMethodNameFromParams(methodParams: String): String
}

class ObjectiveCDoc(declaration: String,
                    type: Type,
                    description: String? = null,
                    params: Map<String, String>? = null,
                    version: String? = null,
                    author: List<String>? = null,
                    returnParams: String? = null,
                    exceptions: List<String>? = null,
                    deprecated: String? = null) : Doc(declaration, type, description, params, version, author, returnParams, exceptions, deprecated, Language.OBJECTIVE_C) {

    override fun provideNameByType(type: Type, pattern: Pair<Regex, Int>, matcher: MatchResult): String {
        return when (type) {
            Type.METHOD -> "${matcher.groupValues[pattern.second]}:${generateMethodNameFromParams(matcher.groupValues[pattern.second + 1])}"
            else -> super.provideNameByType(type, pattern, matcher)
        }
    }

    override fun generateMethodNameFromParams(methodParams: String): String
            = join(value = methodParams,
            regex = Regex("\\([\\w\\d\\s*]+\\)[\\w\\d]+(\\s+[^(^:]*:)?"),
            groupNumber = 1,
            divider = "")
}

class KotlinDoc(declaration: String,
                type: Type,
                description: String? = null,
                params: Map<String, String>? = null,
                version: String? = null,
                author: List<String>? = null,
                returnParams: String? = null,
                exceptions: List<String>? = null,
                deprecated: String? = null) : Doc(declaration, type, description, params, version, author, returnParams, exceptions, deprecated, Language.KOTLIN) {

    override fun generateMethodNameFromParams(methodParams: String): String
            = join(value = methodParams,
            regex = Regex("(@\\w*\\s+)?([\\w\\d]+):([\\w\\d]+)(\\s*<.*>)?[,)]"),
            groupNumber = 3)
}

class JavaDoc(declaration: String,
              type: Type,
              description: String? = null,
              params: Map<String, String>? = null,
              version: String? = null,
              author: List<String>? = null,
              returnParams: String? = null,
              exceptions: List<String>? = null,
              deprecated: String? = null) : Doc(declaration, type, description, params, version, author, returnParams, exceptions, deprecated, Language.JAVA) {

    override fun generateMethodNameFromParams(methodParams: String): String
            = join(value = methodParams,
            regex = Regex("(@\\w*\\s+)?([\\w\\d]*)(\\s*<.*>)?\\s+([\\w\\d]+)\\s*[,)]"),
            groupNumber = 2)
}

class ActionScriptDoc(declaration: String,
                      type: Type,
                      description: String? = null,
                      params: Map<String, String>? = null,
                      version: String? = null,
                      author: List<String>? = null,
                      returnParams: String? = null,
                      exceptions: List<String>? = null,
                      deprecated: String? = null) : Doc(declaration, type, description, params, version, author, returnParams, exceptions, deprecated, Language.ACTION_SCRIPT) {

    override fun generateMethodNameFromParams(methodParams: String): String
            = join(value = methodParams,
            regex = Regex("(@\\w*\\s+)?([\\w\\d]+):([\\w\\d]+)(\\s*<.*>)?[,)]"),
            groupNumber = 3)
}


private fun join(value: String, regex: Regex, groupNumber: Int, divider: String = ", "): String {
    val builder = StringBuilder()
    val findAll = regex
            .findAll(value)
    val count = findAll.count()
    findAll.forEachIndexed { index, matchResult ->
        builder.append(matchResult.groupValues[groupNumber].trim())
        if (index != count - 1) {
            builder.append(divider)
        }
    }

    return builder.toString()
}