package com.smu.mkdocer.config

import com.smu.mkdocer.data.OS

data class Config constructor(val path: String,
                              val resultPath: String,
                              val os: OS)

object ConfigProvider {
    lateinit var config: Config

    fun buildConfig(params: Array<String>): Config {
        if (params.isEmpty()) {
            throw IllegalArgumentException("You must specify path to your project")
        }

        config = Config(params[0], if (params.size == 1) params[0] else params[1], OS.valueOf(params[2].toUpperCase()))
        return config
    }
}