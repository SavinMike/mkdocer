package com.smu.mkdocer.data

import java.util.regex.Pattern

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
    Language.OBJECTIVE_C -> TODO()
}