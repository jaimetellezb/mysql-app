package com.example.core.util

import com.example.core.dto.UserDto
import com.example.infrastructure.database.entity.UserEntity
import javax.inject.Singleton

@Singleton
class Mapper {

    fun dtoToEntity(dto: UserDto) = UserEntity(
        name = dto.name,
        address = dto.address,
        phone = dto.phone,
        gender = dto.gender,
        documentNumber = dto.documentNumber,
        documentType = dto.documentType,
        email = dto.email
    )
}