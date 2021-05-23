package com.example.controller

import com.example.core.service.AwsService
import com.example.infrastructure.configuration.S3Configuration
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.http.server.types.files.StreamedFile
import org.slf4j.LoggerFactory
import java.io.File
import java.io.InputStream
import javax.inject.Inject


@Controller("v1/api/aws")
class AwsController {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Inject
    lateinit var awsService: AwsService

    @Inject
    lateinit var configuration: S3Configuration

    @Get
    @Produces(value = [MediaType.APPLICATION_PDF])
    fun download(): StreamedFile {
        val fileName = "data.pdf"
        var file = File(fileName)
        file.writeText("Archivo PDF cargado en AWS S3")
        val inputStream: InputStream = file.inputStream()
        return StreamedFile(inputStream, MediaType.APPLICATION_PDF_TYPE)
        // An attach(String filename) method is also available to set the Content-Disposition
    }

    @Post
    @Consumes(value = [MediaType.MULTIPART_FORM_DATA])
    fun loadFileS3(): HttpResponse<Any> {
        return awsService.loadFileS3(configuration)
    }


}