package com.example.core.service

import com.example.core.outbound.UserRepositoryService
import com.example.core.util.Mapper
import com.example.infrastructure.cloud.aws.S3Service
import com.example.infrastructure.configuration.S3Configuration
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class AwsServiceImpl(private val s3Service: S3Service, private val mapper: Mapper) :
    AwsService {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun loadFileS3(s3Configuration: S3Configuration): HttpResponse<Any> {
        logger.info("ENTITY ")
        s3Service.putObject("", s3Configuration)
        return HttpResponse.status<Any>(HttpStatus.OK).body("OK")
    }

}