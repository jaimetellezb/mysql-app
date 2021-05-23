package com.example.core.service

import com.example.infrastructure.configuration.S3Configuration
import io.micronaut.http.HttpResponse

interface AwsService {
    fun loadFileS3(s3Configuration: S3Configuration): HttpResponse<Any>
}