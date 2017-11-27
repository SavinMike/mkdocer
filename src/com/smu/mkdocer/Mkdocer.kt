package com.smu.mkdocer

import com.smu.mkdocer.config.Config
import com.smu.mkdocer.generator.DocFileGenerator
import com.smu.mkdocer.parser.FileParserProvider
import com.smu.mkdocer.template.Template
import java.io.File

class Mkdocer(private val config: Config,
              private val template: Template) {

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
        val fileParser = FileParserProvider.createFileParser(file)

        if (fileParser == null) {
            println("Unknown format for file $file")
            return
        }

        val docs = fileParser.parseFile(file)

        val subSequence = file.absolutePath.subSequence(file.absolutePath.indexOf("com/pushwoosh/") + "com/pushwoosh/".length, file.absolutePath.indexOf(file.name))

        val parent = File(config.resultPath, subSequence.toString())
        parent.mkdirs()

        val rootPath = File(parent, "${file.nameWithoutExtension}.txt")
        docs?.forEach { docFileGenerator.generateByDoc(it, template) }
        val text = docFileGenerator.text
        if (text.trim().isNotEmpty()) {
            rootPath.createNewFile()
            rootPath.writeText(text)
        }
    }
}