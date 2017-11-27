package com.smu.mkdocer.generator

import com.smu.mkdocer.config.ConfigProvider
import com.smu.mkdocer.data.Doc
import com.smu.mkdocer.template.Template
import java.io.File

interface DocFileGenerator {
    fun generateByDoc(doc: Doc,
                      template: Template)

    val text: String

    fun clear()
}