package com.smu.mkdocer.data

enum class Type {
    CLASS,
    METHOD,
    ENUM,
    PROPERTY,
    FIELD;
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
        Language.ACTION_SCRIPT -> Type.METHOD
    }
}

fun Type.pattern(language: Language): Pair<Regex, Int>? = when (language) {

    Language.JAVA -> when (this) {
        Type.CLASS -> Pair(Regex("public(\\sstatic)?(\\sabstract)?(\\sfinal)?\\s+(class|interface)\\s+([\\w\\d]+(<.*>)?)(\\s+extends\\s+[\\w\\d]+(<.*>)?)?(\\s+implements\\s+[\\w\\d]+(<.*>)?)?\\s*\\{?"), 5)
        Type.FIELD -> Pair(Regex("public(\\sstatic)?(\\sfinal)? [\\w\\d<>]+ ([\\w\\d]+)\\s*="), 3)
        Type.METHOD -> Pair(Regex("^\\s*(public|protected)?(\\sstatic)?(\\sabstract)?(\\sfinal)? [\\w\\d<>]+ ([\\w\\d]+)(\\(.*\\))"), 5)
        Type.ENUM -> Pair(Regex("public(\\sstatic)?(\\sfinal)?\\s+enum\\s+([\\w\\d]+)\\s*\\{?"), 3)
        else -> null
    }

    Language.KOTLIN -> when (this) {
        Type.CLASS -> Pair(Regex("^(object|(sealed)?\\s*class|interface) ([\\w\\d]+(<.*>)?) \\{?"), 3)
        Type.PROPERTY -> Pair(Regex("(var|val) ([\\w\\d]+)\\s*(:\\s[\\w\\d<>?]+)?\\s(=\\s.*)?"), 2)
        Type.METHOD -> Pair(Regex("fun ([\\w\\d]+)(\\(.*\\))\\s*(:\\s*[\\w\\d<>?]+)?\\s(=\\s.*)?"), 1)
        Type.ENUM -> Pair(Regex("enum\\s+class\\s+(.*)\\s*\\{"), 1)
        else -> null
    }

    Language.OBJECTIVE_C -> when (this) {
        Type.CLASS -> Pair(Regex("@(interface|protocol|class)\\s+([\\w\\d]*)(\\s*:\\s*[\\w\\d]*)?"), 2)
        Type.PROPERTY -> Pair(Regex("@property(\\s\\([^)]+\\))\\s+([\\w\\d<>,]+)\\s*(\\*?\\s*[\\w\\d]+)"), 3)
        Type.METHOD -> Pair(Regex("\\s*([+-])\\s*(\\([^(]*\\))([\\w\\d]+)(:(\\(.+\\)[\\w\\d]+(\\s|;)?)*)?"), 3)
        Type.ENUM -> Pair(Regex("(typedef )?\\s*NS_ENUM\\s*\\(.*\\s*,\\s*(.*)\\)"), 2)
        Type.FIELD -> Pair(Regex("(FOUNDATION_EXPORT )?\\s*([\\w\\d]+)(\\s*\\*\\s*|\\s+)(const\\s+)?([\\w\\d]+)"), 5)
    }

    Language.ACTION_SCRIPT -> when (this) {
        Type.CLASS -> Pair(Regex("public(\\sstatic)?(\\sabstract)?(\\sfinal)?\\s+(class|interface)\\s+([\\w\\d]+(<.*>)?)(\\s+extends\\s+[\\w\\d]+(<.*>)?)?(\\s+implements\\s+[\\w\\d]+(<.*>)?)?\\s*\\{?"), 5)
        Type.FIELD -> Pair(Regex("public(\\sstatic)?(var|val) ([\\w\\d]+)\\s*(:\\s[\\w\\d<>?]+)?\\s(=\\s.*)?"), 3)
        Type.METHOD -> Pair(Regex("^\\s*(public|protected)?(\\sstatic)?(\\sabstract)?(\\sfinal)? function(\\sget)? ([\\w\\d]+)(\\(.*\\))(\\s*:\\s*(.*)|$)"), 6)
        else -> null
    }

}