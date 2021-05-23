package com.example.infrastructure.cloud.aws

import com.example.infrastructure.configuration.S3Configuration

interface S3Service {
    fun putObject(filePath: String, configuration: S3Configuration)
}