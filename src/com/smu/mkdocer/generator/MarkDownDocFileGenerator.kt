package com.smu.mkdocer.generator

import com.smu.mkdocer.data.Doc
import com.smu.mkdocer.template.Template
import com.smu.mkdocer.template.createLink
import com.smu.mkdocer.template.divider

class MarkDownDocFileGenerator : DocFileGenerator {
    override val text: String
        get() = docStringBuilder.toString()

    private var docStringBuilder = StringBuilder()

    override fun generateByDoc(doc: Doc, template: Template) {
        docStringBuilder.append("### ${doc.name} <a name=\"${doc.name.createLink()}\"></a>")
                .append("\n")
                .append(template.mapDescription(doc.description))
                .append("\n")
                .append(template.mapParams(doc.params))
                .append(if (doc.returnParams == null) "" else "${template.mapReturnParams(doc.returnParams)}\n")
                .append(template.mapDeclaration(doc.declaration))
                .append("\n")
                .append(divider())
                .append("\n")
    }

    override fun clear() {
        docStringBuilder = StringBuilder()
    }
}
