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
    abstract val name: String
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
    override val name: String
        get() {
            val pattern = type.pattern(language)
            val matcher = pattern?.first?.find(declaration)
            return if (matcher != null) {
                when (type) {
                    Type.METHOD -> "${matcher.groupValues[pattern.second]}:${generateNameFromParams(matcher.groupValues[pattern.second + 1])}"
                    else -> matcher.groupValues[pattern.second]
                }
            } else {
                ""
            }
        }

    private fun generateNameFromParams(methodParams: String): String {
        val builder = StringBuilder()
        val findAll = Regex("\\([\\w\\d\\s*]+\\)[\\w\\d]+(\\s+[^(^:]*:)?")
                .findAll(methodParams)
        findAll.forEach { matchResult ->
            builder.append(matchResult.groupValues[1].trim())
        }
        return builder.toString()
    }
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
    override val name: String
        get() {
            val pattern = type.pattern(language)
            val matcher = pattern?.first?.find(declaration)
            return if (matcher != null) {
                when (type) {
                    Type.METHOD -> "${matcher.groupValues[pattern.second]}(${generateNameFromParams(matcher.groupValues[pattern.second + 1])})"
                    else -> matcher.groupValues[pattern.second]
                }
            } else {
                ""
            }
        }

    private fun generateNameFromParams(methodParams: String): String {
        val builder = StringBuilder()
        val findAll = Regex("(@\\w*\\s+)?([\\w\\d]+):([\\w\\d]+)(\\s*<.*>)?[,)]")
                .findAll(methodParams)
        val count = findAll.count()
        findAll.forEachIndexed { index, matchResult ->
            builder.append(matchResult.groupValues[3])
            if (index != count - 1) {
                builder.append(", ")
            }
        }

        return builder.toString()
    }
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
    override val name: String
        get() {
            val pattern = type.pattern(language)
            val matcher = pattern?.first?.find(declaration)
            return if (matcher != null) {
                when (type) {
                    Type.METHOD -> "${matcher.groupValues[pattern.second]}(${generateNameFromParams(matcher.groupValues[pattern.second + 1])})"
                    else -> matcher.groupValues[pattern.second]
                }
            } else {
                ""
            }
        }

    private fun generateNameFromParams(methodParams: String): String {
        val builder = StringBuilder()
        val findAll = Regex("(@\\w*\\s+)?([\\w\\d]*)(\\s*<.*>)?\\s+([\\w\\d]+)\\s*[,)]")
                .findAll(methodParams)
        val count = findAll.count()
        findAll.forEachIndexed { index, matchResult ->
            builder.append(matchResult.groupValues[2])
            if (index != count - 1) {
                builder.append(", ")
            }
        }

        return builder.toString()
    }
}
