package com.smu.mkdocer.parser

import com.smu.mkdocer.data.Doc
import java.io.File

interface FileParser {
    fun parseFile(file: File): Collection<Doc>?
}

object FileParserProvider {
    fun createFileParser(file: File): FileParser? = when (file.extension) {
        "kt" -> KotlinFileParser()
        "java" -> JavaFileParser()
        else -> null
    }
}