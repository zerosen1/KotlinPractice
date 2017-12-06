package com.javasampleapproach.uploadfile.controller

import java.util.ArrayList
import java.util.stream.Collectors

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder

import com.javasampleapproach.uploadfile.storage.StorageService

@Controller
class UploadController {

    @Autowired
    internal var storageService: StorageService? = null

    internal var files: MutableList<String> = ArrayList()

    @GetMapping("/")
    fun listUploadedFiles(model: Model): String {
        return "uploadForm"
    }

    @PostMapping("/")
    fun handleFileUpload(@RequestParam("file") file: MultipartFile, model: Model): String {
        try {
            storageService!!.store(file)
            model.addAttribute("message", "You successfully uploaded " + file.originalFilename + "!")
            files.add(file.originalFilename)
        } catch (e: Exception) {
            model.addAttribute("message", "FAIL to upload " + file.originalFilename + "!")
        }

        return "uploadForm"
    }

    @GetMapping("/gellallfiles")
    fun getListFiles(model: Model): String {
        model.addAttribute("files",
                files.stream()
                        .map { fileName ->
                            MvcUriComponentsBuilder
                                    .fromMethodName(UploadController::class.java!!, "getFile", fileName).build().toString()
                        }
                        .collect<List<String>, Any>(Collectors.toList()))
        model.addAttribute("totalFiles", "TotalFiles: " + files.size)
        return "listFiles"
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    fun getFile(@PathVariable filename: String): ResponseEntity<Resource> {
        val file = storageService!!.loadFile(filename)
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.filename + "\"")
                .body(file)
    }
}