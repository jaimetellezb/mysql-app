package com.example.infrastructure.configuration

import io.micronaut.core.annotation.NonNull

interface S3Configuration {
    @NonNull
    fun getBucket(): String?

    @NonNull
    fun getRegion(): String?

    @NonNull
    fun getAccessKey(): String?

    @NonNull
    fun getSecretKey(): String?
}