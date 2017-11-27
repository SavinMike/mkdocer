package com.smu.mkdocer.parser

import com.smu.mkdocer.data.*
import com.smu.mkdocer.data.Deprecated
import java.io.File

class JavaFileParser : FileParser {

    override fun parseFile(file: File): Collection<Doc>? {
        val docFinder = DocFinder(Language.JAVA)
        val result = mutableListOf<Doc>()
        file.forEachLine {
            docFinder.findComment(it)
                    ?.takeIf {
                        it.also {
                            result.add(generateDoc(docFinder.commentDeclaration, docFinder.commentBody))
                            docFinder.clear()
                        }
                    }

        }

        return result
    }

    private fun generateDoc(docDeclaration: String, docString: String): Doc {
        var description = docString
        val type = docDeclaration.getDocType(Language.JAVA) ?: Type.FIELD
        val paramsData = mutableMapOf<String, String>()
        val authorData = mutableListOf<String>()
        var version: String? = null
        var returnParams: String? = null
        val exceptions = mutableListOf<String>()
        var deprecated: String? = null

        setOf(Params(), Author(), Version(), Return(), Throws(), Deprecated(), CodeParam(), SeeParam())
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

        return JavaDoc(declaration = docDeclaration,
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

