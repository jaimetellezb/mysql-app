package com.example.infrastructure.configuration

import io.micronaut.context.annotation.Value
import javax.inject.Singleton

@Singleton
class S3ConfigurationProperties(
    @Value("\${aws.s3.secretKey}")
    private final val secretKey: String,
    @Value("\${aws.s3.accessKey}")
    private val accessKey: String,
    @Value("\${aws.s3.region}")
    private val region: String,
    @Value("\${aws.s3.bucket}")
    private val bucket: String
) : S3Configuration {

    override fun getBucket(): String? {
        return bucket
    }

    override fun getRegion(): String? {
        return region
    }

    override fun getAccessKey(): String? {
        return accessKey
    }

    override fun getSecretKey(): String? {
        return secretKey
    }

}