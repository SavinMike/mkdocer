package com.smu.mkdocer.parser

import com.smu.mkdocer.data.*
import com.smu.mkdocer.data.Deprecated
import com.smu.mkdocer.parser.finder.DocFinder
import java.io.File

open class FileParser(private val language: Language) {
    fun parseFile(file: File): Collection<Doc>? {
        val docFinder = DocFinder(language)
        val result = mutableListOf<Doc>()
        file.forEachLine {
            docFinder.findComment(it)
                    ?.takeIf {
                        it.also {
                            result.add(generateDoc(docFinder.commentDeclaration.trim(), docFinder.commentBody.trim()))
                            docFinder.clear()
                        }
                    }

        }

        return result
    }

    protected open fun generateDoc(docDeclaration: String, docString: String): Doc {
        var description = docString
        val type = docDeclaration.getDocTypeOrDefault(language)
        val paramsData = mutableMapOf<String, String>()
        val authorData = mutableListOf<String>()
        var version: String? = null
        var returnParams: String? = null
        val exceptions = mutableListOf<String>()
        var deprecated: String? = null

        setOf(Params(), Author(), Version(), Return(), Throws(), Deprecated(), CodeParam(language), SeeParam())
                .forEach {
                    when (it) {
                        is Params -> paramsData.putAll(it.obtainData(description))
                        is Author -> authorData.addAll(it.obtainData(description))
                        is Version -> version = it.obtainData(description)
                        is Return -> returnParams = it.obtainData(description)
                        is Throws -> exceptions.addAll(it.obtainData(description))
                        is Deprecated -> deprecated = it.obtainData(description)
                        else -> description = it.replaceData(description, it.obtainData(description))
                    }

                    description = it.removeFromString(description)
                }

        return when (language) {
            Language.JAVA -> JavaDoc(declaration = docDeclaration,
                    type = type,
                    params = paramsData,
                    author = authorData,
                    version = version,
                    returnParams = returnParams,
                    exceptions = exceptions,
                    deprecated = deprecated,
                    description = description)
            Language.KOTLIN -> KotlinDoc(declaration = docDeclaration,
                    type = type,
                    params = paramsData,
                    author = authorData,
                    version = version,
                    returnParams = returnParams,
                    exceptions = exceptions,
                    deprecated = deprecated,
                    description = description)
            Language.OBJECTIVE_C -> ObjectiveCDoc(declaration = docDeclaration,
                    type = type,
                    params = paramsData,
                    author = authorData,
                    version = version,
                    returnParams = returnParams,
                    exceptions = exceptions,
                    deprecated = deprecated,
                    description = description)
            Language.ACTION_SCRIPT -> ActionScriptDoc(declaration = docDeclaration,
                    type = type,
                    params = paramsData,
                    author = authorData,
                    version = version,
                    returnParams = returnParams,
                    exceptions = exceptions,
                    deprecated = deprecated,
                    description = description)
        }
    }
}

object FileParserProvider {
    fun createFileParser(language: Language): FileParser = FileParser(language)
}

fun File.getLanguage(): Language? = when (extension) {
    "kt" -> Language.KOTLIN
    "java" -> Language.JAVA
    "h" -> Language.OBJECTIVE_C
    "as" -> Language.ACTION_SCRIPT
    else -> null
}