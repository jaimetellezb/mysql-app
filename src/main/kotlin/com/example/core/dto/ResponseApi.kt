package com.example.core.dto

data class ResponseApi <T>(val statusCode: Int, val data: T)