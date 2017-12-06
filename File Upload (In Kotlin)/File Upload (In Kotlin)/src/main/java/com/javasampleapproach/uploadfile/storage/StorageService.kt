package com.javasampleapproach.uploadfile.storage

import java.io.IOException
import java.net.MalformedURLException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Service
import org.springframework.util.FileSystemUtils
import org.springframework.web.multipart.MultipartFile


@Service
class StorageService {

    internal var log = LoggerFactory.getLogger(this.javaClass.getName())
    private val rootLocation = Paths.get("upload-dir")

    fun store(file: MultipartFile) {
        try {
            Files.copy(file.inputStream, this.rootLocation.resolve(file.originalFilename))
        } catch (e: Exception) {
            throw RuntimeException("FAIL!")
        }

    }

    fun loadFile(filename: String): Resource {
        try {
            val file = rootLocation.resolve(filename)
            val resource = UrlResource(file.toUri())
            return if (resource.exists() || resource.isReadable) {
                resource
            } else {
                throw RuntimeException("FAIL!")
            }
        } catch (e: MalformedURLException) {
            throw RuntimeException("FAIL!")
        }

    }

    fun deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile())
    }

    fun init() {
        try {
            Files.createDirectory(rootLocation)
        } catch (e: IOException) {
            throw RuntimeException("Could not initialize storage!")
        }

    }
}