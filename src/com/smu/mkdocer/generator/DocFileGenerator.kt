package com.smu.mkdocer.generator

import com.smu.mkdocer.data.Doc
import com.smu.mkdocer.template.Template

interface DocFileGenerator {
    val text: String
    fun clear()
    fun generateByDoc(doc: Doc, template: Template)
}