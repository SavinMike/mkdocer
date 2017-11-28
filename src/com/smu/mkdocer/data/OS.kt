package com.smu.mkdocer.data

import java.io.File

enum class OS {
    ANDROID,
    IOS
}

object ProguardHelper {
    fun publicClasses(appRoot: File): Collection<String> {
        val proguardClasses: MutableList<String> = mutableListOf()
        val proguards = mutableSetOf<File>()
        publicClasses(appRoot, proguards)
        proguards.forEach {
            fillProguardClasses(it, proguardClasses)
        }
        return proguardClasses
    }

    private fun fillProguardClasses(it: File, proguardClasses: MutableList<String>) {
        if (!it.exists()) {
            return
        }

        if (it.isFile) {
            updateProguard(it, proguardClasses)
        }

        if (it.isDirectory) {
            it.listFiles().forEach { fillProguardClasses(it, proguardClasses) }
        }
    }


    private fun updateProguard(it: File, proguardClasses: MutableCollection<String>) {
        val readText = it.readText()
        Regex("-[\\w]+ (public )?\\w* (.*) (\\{)?")
                .findAll(readText)
                .forEach {
                    proguardClasses.add(it.groupValues[2].replace("$*", "").replace(".", "/"))
                }
    }

    private fun publicClasses(appRoot: File, files: MutableCollection<File>) {
        if (appRoot.isDirectory) {
            appRoot.listFiles().forEach {
                if (it.name == "build.gradle") {
                    files.addAll(parseProguard(it))
                }

                if (it.isDirectory) {
                    publicClasses(it, files)
                }
            }
        }
    }

    private fun parseProguard(buildGradle: File): Collection<File> {
        val readText = buildGradle.readText()

        val result = mutableListOf<File>()

        Regex("proguardFiles (.*)")
                .findAll(readText)
                .forEach {
                    val filePaths = it.groupValues[1]

                    val split = filePaths.split(Regex("\\s*,\\s*"))
                    split.forEach {
                        if (it.contains("getDefaultProguardFile")) {
                            val element = Regex("getDefaultProguardFile\\s*\\(['\"](.*)['\"]\\)\\s*").find(it)
                            if (element != null) {
                                result.add(File(buildGradle.parentFile, element.groupValues[1]))
                            }
                        } else if (it.contains("file")) {
                            val element = Regex("file\\s*\\(['\"]([^'^\"]*)['\"]\\)").find(it)
                            if (element != null) {
                                val groovyFile = element.groupValues[1]
                                val groovyFileSplit = groovyFile.split("../")
                                var levelDownSize = groovyFileSplit.size
                                var parent = buildGradle
                                while (levelDownSize != 0) {
                                    parent = parent.parentFile
                                    levelDownSize--
                                }

                                result.add(File(parent, groovyFileSplit.last()))
                            }
                        } else {
                            val element = Regex("['\"](.*)['\"]").find(it)
                            if (element != null) {
                                result.add(File(buildGradle.parentFile, element.groupValues[1]))
                            }
                        }
                    }
                }

        return result
    }
}

object XcodeProjHelper {
    fun publicHeaders(appRoot: File): Collection<String> {
        val result = mutableSetOf<String>()
        publicHeaders(appRoot, result)
        return result
    }

    private fun publicHeaders(appRoot: File, files: MutableCollection<String>) {
        if (appRoot.isDirectory) {
            appRoot.listFiles().forEach {
                if (it.name.endsWith(".pbxproj")) {
                    files.addAll(parseXproj(it))
                }

                if (it.isDirectory) {
                    publicHeaders(it, files)
                }
            }
        }
    }

    private fun parseXproj(file: File): Collection<String> {
        val result = mutableSetOf<String>()
        file.forEachLine {
            Regex("[\\w\\d]+ /\\*.+\\*/ = \\{(.*settings\\s*=\\s*\\{.*ATTRIBUTES\\s*=\\s*\\(.*Public.*\\);\\s}.*)}")
                    .find(it)
                    ?.apply {
                        val element = provideHeaderName(this.groupValues[1])
                        if (element != null) {
                            result.add(element)
                        }
                    }

        }

        return result
    }

    private fun provideHeaderName(xprojValue: String): String? = Regex("fileRef\\s*=\\s*[\\w\\d]+\\s*/\\*\\s*(.+\\.h)\\s*\\*/")
            .find(xprojValue)
            ?.groupValues?.get(1)
}