package com.example.infrastructure.cloud.aws

import com.example.infrastructure.configuration.S3Configuration
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.PutObjectRequest
import java.io.File
import java.io.IOException
import java.nio.ByteBuffer
import java.util.*
import javax.inject.Singleton

@Singleton
class S3ServiceImpl : S3Service {
    private lateinit var s3: S3Client

    private fun authentication(configuration: S3Configuration) {
        val credentials: AwsBasicCredentials = AwsBasicCredentials.create(
            configuration.getAccessKey(),
            configuration.getSecretKey()
        )
        val region: Region = Region.US_WEST_1
        s3 = S3Client.builder().region(region)
            .credentialsProvider(StaticCredentialsProvider.create(credentials)).build()

    }

    override fun putObject(filePath: String, configuration: S3Configuration) {
        authentication(configuration)

        val fileName = "data.txt"
        var file = File(fileName)
        file.writeText("Archivo de texto cargado en AWS S3")


        val objectRequest = PutObjectRequest.builder()
            .bucket(configuration.getBucket())
            .key(fileName + 1)
            .build()

        s3.putObject(objectRequest, RequestBody.fromFile(file))
        println("The file $filePath has been uploaded")


    }

    @Throws(IOException::class)
    private fun getRandomByteBuffer(size: Int): ByteBuffer? {
        val b = ByteArray(size)
        Random().nextBytes(b)
        return ByteBuffer.wrap(b)
    }
}


