package com.smu.mkdocer.data

enum class Type {
    CLASS,
    FIELD,
    PROPERTY,
    METHOD;
}

fun String.getDocType(language: Language): Type? {
    Type.values().forEach {
        if (it.pattern(language)?.first?.find(this) != null) {
            return it
        }
    }

    return null
}

fun String.getDocTypeOrDefault(language: Language): Type {
    return getDocType(language) ?: language.getDefaultType()
}

internal fun Language.getDefaultType(): Type {
    return when (this) {
        Language.JAVA -> Type.FIELD
        Language.KOTLIN -> Type.PROPERTY
        Language.OBJECTIVE_C -> Type.PROPERTY
    }
}

fun Type.pattern(language: Language): Pair<Regex, Int>? = when (language) {

    Language.JAVA -> when (this) {
        Type.CLASS -> Pair(Regex("public(\\sstatic)?(\\sfinal)? (class|enum|interface) ([\\w\\d]+(<.*>)?) \\{?"), 4)
        Type.FIELD -> Pair(Regex("public(\\sstatic)?(\\sfinal)? [\\w\\d<>]+ ([\\w\\d]+)\\s*="), 3)
        Type.METHOD -> Pair(Regex("public(\\sstatic)?(\\sfinal)? [\\w\\d<>]+ ([\\w\\d]+)(\\(.*\\))"), 3)
        else -> null
    }
    Language.KOTLIN -> when (this) {
        Type.CLASS -> Pair(Regex("^(object|(enum|sealed) class|interface) ([\\w\\d]+(<.*>)?) \\{?"), 3)
        Type.PROPERTY -> Pair(Regex("(var|val) ([\\w\\d]+)\\s*(:\\s[\\w\\d<>?]+)?\\s(=\\s.*)?"), 2)
        Type.METHOD -> Pair(Regex("fun ([\\w\\d]+)(\\(.*\\))\\s*(:\\s*[\\w\\d<>?]+)?\\s(=\\s.*)?"), 1)
        else -> null
    }
    Language.OBJECTIVE_C -> when (this) {

        Type.CLASS -> Pair(Regex("@(interface|protocol|class)\\s+([\\w\\d]*)(\\s*:\\s*[\\w\\d]*)?"), 2)
        Type.PROPERTY -> Pair(Regex("@property(\\s\\([\\w\\d,]+\\))\\s+([\\w\\d]+)\\s+(\\*?[\\w\\d]+);"), 4)
        Type.METHOD -> Pair(Regex("\\s*([+-])\\s*(\\([^(]*\\))([\\w\\d]+)(:(\\(.+\\)[\\w\\d]+(\\s|;)?)*)?"), 3)
        else -> null
    }
}