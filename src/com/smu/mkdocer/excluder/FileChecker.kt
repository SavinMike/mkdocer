package com.smu.mkdocer.excluder

import com.smu.mkdocer.PW_EXCLUDES
import com.smu.mkdocer.data.OS
import com.smu.mkdocer.data.ProguardHelper
import com.smu.mkdocer.data.XcodeProjHelper
import java.io.File

interface FileChecker {
    fun check(file: File): Boolean
}

class AndroidFileChecker(appPath: File) : FileChecker {
    companion object {
        private val EXCLUDE_FOLDERS = arrayOf("build", "src/test")
    }

    private val proguardClasses: Collection<String> = ProguardHelper.publicClasses(appPath)

    override fun check(file: File): Boolean {
        EXCLUDE_FOLDERS.forEach {
            if (file.absolutePath.contains(it)) {
                return false
            }
        }

        PW_EXCLUDES.forEach {
            if (file.absolutePath.contains(Regex(it))) {
                return false
            }
        }

        if (proguardClasses.isEmpty()) {
            return true
        }

        proguardClasses.forEach {
            if (when {
                it.endsWith("**") -> file.absolutePath.contains(it.subSequence(0, it.length - 2))
                it.endsWith("*") -> file.parentFile.absolutePath.endsWith(it)
                else -> "${file.parentFile.absoluteFile}/${file.nameWithoutExtension}".endsWith(it)
            }) {
                return true
            }
        }
        return false
    }
}

class IosChecker(appPath: File) : FileChecker {

    private val publicHeaders: Collection<String> = XcodeProjHelper.publicHeaders(appPath)

    override fun check(file: File): Boolean {

        if (publicHeaders.isEmpty()) {
            return true
        }

        publicHeaders.forEach {
            if ("${file.parentFile.absoluteFile}/${file.name}".endsWith(it)) {
                return true
            }
        }
        return false
    }
}


object FileCheckerProvider {
    fun createFileChecker(os: OS, appPath: File): FileChecker? = when (os) {
        OS.ANDROID -> AndroidFileChecker(appPath)
        OS.IOS -> IosChecker(appPath)
    }
}