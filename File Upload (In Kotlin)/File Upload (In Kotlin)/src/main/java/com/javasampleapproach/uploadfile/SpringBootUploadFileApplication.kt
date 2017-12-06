package com.javasampleapproach.uploadfile

import javax.annotation.Resource

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

import com.javasampleapproach.uploadfile.storage.StorageService

@SpringBootApplication
class SpringBootUploadFileApplication : CommandLineRunner {

    @Resource
    internal var storageService: StorageService? = null

    @Throws(Exception::class)
    override fun run(vararg args: String) {
        storageService!!.deleteAll()
        storageService!!.init()
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SpringBootUploadFileApplication::class.java, *args)
        }
    }
}
