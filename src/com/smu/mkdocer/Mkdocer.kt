package com.smu.mkdocer

import com.smu.mkdocer.config.Config
import com.smu.mkdocer.excluder.Excluder
import com.smu.mkdocer.excluder.ExcluderProvider
import com.smu.mkdocer.fileprovider.FileProvider
import com.smu.mkdocer.generator.DocFileGenerator
import com.smu.mkdocer.parser.FileParserProvider
import com.smu.mkdocer.parser.getLanguage
import com.smu.mkdocer.template.Template
import java.io.File

class Mkdocer(private val config: Config,
              private val template: Template) {

    private val excluder: Excluder? = ExcluderProvider.createExcluderProvider(config.os)

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
            if (excluder?.exclude(rootFile) == true) {
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