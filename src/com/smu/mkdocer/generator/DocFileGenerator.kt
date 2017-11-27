package com.smu.mkdocer.generator

import com.smu.mkdocer.data.Doc
import com.smu.mkdocer.template.Template

interface DocFileGenerator {
    fun generateByDoc(doc: Doc,
                      template: Template)

    val text: String

    fun clear()
}