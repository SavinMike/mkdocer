package com.smu.mkdocer.fileprovider

import com.smu.mkdocer.PW_ANDROID_PACKAGE
import com.smu.mkdocer.PW_IOS_PACKAGE
import com.smu.mkdocer.data.Language
import java.io.File

interface FileHelper {
    fun generateParentOutputFile(file: File, resultPath: String): File
}

internal class AndroidHelper : FileHelper {
    override fun generateParentOutputFile(file: File, resultPath: String): File {
        val subSequence = file.absolutePath.subSequence(file.absolutePath.indexOf(PW_ANDROID_PACKAGE) + PW_ANDROID_PACKAGE.length, file.absolutePath.indexOf(file.name))

        val parent = File(resultPath, subSequence.toString())
        parent.mkdirs()

        return parent
    }
}

internal class IosHelper : FileHelper {
    override fun generateParentOutputFile(file: File, resultPath: String): File {
        val subSequence = file.absolutePath.subSequence(file.absolutePath.indexOf(PW_IOS_PACKAGE) + PW_IOS_PACKAGE.length, file.absolutePath.indexOf(file.name))

        val parent = File(resultPath, subSequence.toString())
        parent.mkdirs()

        return parent
    }
}


object FileProvider {
    fun createFileHelper(language: Language) = when (language) {
        Language.JAVA -> AndroidHelper()
        Language.KOTLIN -> AndroidHelper()
        Language.OBJECTIVE_C -> IosHelper()
    }

    fun getFileParent(language: Language, file: File, resultPath: String) = createFileHelper(language).generateParentOutputFile(file, resultPath)
}