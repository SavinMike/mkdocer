package com.smu.mkdocer.config

import com.smu.mkdocer.data.OS

data class Config constructor(val inputPath: String,
                              val outputPath: String,
                              val os: OS)

object ConfigProvider {
    lateinit var config: Config

    fun buildConfig(params: Array<String>): Config {
        if (params.size !in 2..3) {
            throw IllegalArgumentException("Incorrect params. Params should be the next 1) inputPath. 2) outputPath. 3) OS (optional).")
        }

        val os: OS
        try {
            os = if (params.size == 2) OS.UNDEFINED else OS.valueOf(params[2].toUpperCase())
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Os is one of the ${OS.values()}")
        }

        config = Config(inputPath = params[0],
                outputPath = params[1],
                os = os)

        return config
    }
}