package com.smu.mkdocer.excluder

import com.smu.mkdocer.data.OS
import java.io.File

interface Excluder {
    fun exclude(file: File): Boolean
}

class AndroidExcluder : Excluder {
    companion object {
        val EXCLUDE_FOLDERS = arrayOf("build", "src/test")
    }

    override fun exclude(file: File): Boolean {
        EXCLUDE_FOLDERS.forEach {
            if (file.absolutePath.contains(Regex("pushwoosh([\\w-]*)/$it"))) {
                return true
            }
        }

        return false
    }
}

object ExcluderProvider {
    fun createExcluderProvider(os: OS): Excluder? = when (os) {
        OS.ANDROID -> AndroidExcluder()
        OS.IOS -> null
    }
}