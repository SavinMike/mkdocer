package com.smu.mkdocer

import com.smu.mkdocer.config.ConfigProvider
import com.smu.mkdocer.generator.MarkDownDocFileGenerator
import com.smu.mkdocer.template.MarkDownTemplate
import java.io.File

fun main(params: Array<String>) {
    val config = ConfigProvider.buildConfig(params)
    val mkdocer = Mkdocer(config, MarkDownTemplate())

    mkdocer.generateDocs(MarkDownDocFileGenerator())
    removeEmptyFolders(File(config.resultPath))
}

fun removeEmptyFolders(file: File) {
    if (file.isFile) {
        return
    }

    file.listFiles().forEach { removeEmptyFolders(it) }

    if (file.listFiles().isEmpty()) {
        file.delete()
        return
    }
}