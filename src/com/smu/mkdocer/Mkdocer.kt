package com.smu.mkdocer

import com.smu.mkdocer.config.Config
import com.smu.mkdocer.excluder.FileChecker
import com.smu.mkdocer.excluder.FileCheckerProvider
import com.smu.mkdocer.fileprovider.FileProvider
import com.smu.mkdocer.generator.DocFileGenerator
import com.smu.mkdocer.parser.FileParserProvider
import com.smu.mkdocer.parser.getLanguage
import com.smu.mkdocer.template.Template
import java.io.File

class Mkdocer(private val config: Config,
              private val template: Template) {

    private val fileChecker: FileChecker? = FileCheckerProvider.createFileChecker(config.os, File(config.path))

    fun generateDocs(docFileGenerator: DocFileGenerator) {
        val rootFile = File(config.path)
        generateDocs(rootFile, docFileGenerator)
    }

    private fun generateDocs(rootFile: File, docFileGenerator: DocFileGenerator) {
        if (!rootFile.exists()) {
            println("File not find $rootFile")
            return
        }

        if (rootFile.isFile) {
            if (fileChecker?.check(rootFile) == false) {
                return
            }
            generateDocFile(rootFile, docFileGenerator)
            docFileGenerator.clear()
        } else {
            rootFile.listFiles()
                    .forEach {
                        generateDocs(it, docFileGenerator)
                    }
        }
    }

    private fun generateDocFile(file: File, docFileGenerator: DocFileGenerator) {
        val language = file.getLanguage() ?: return
        val fileParser = FileParserProvider.createFileParser(language)

        val docs = fileParser.parseFile(file)
        val rootPath = File(FileProvider.getFileParent(language, file, config.resultPath), "${file.nameWithoutExtension}.md")
        docs?.forEach { docFileGenerator.generateByDoc(it, template) }
        val text = docFileGenerator.text
        if (text.trim().isNotEmpty()) {
            rootPath.createNewFile()
            rootPath.writeText(text)
        }
    }
}