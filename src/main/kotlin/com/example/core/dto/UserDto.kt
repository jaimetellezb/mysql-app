package com.example.core.dto

import io.micronaut.core.annotation.Introspected

@Introspected
data class UserDto(
    val name: String,
    val gender: String,
    val documentType: String,
    val documentNumber: String,
    val email: String,
    val phone: Long,
    val address: String
)
