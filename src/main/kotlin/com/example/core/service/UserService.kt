package com.example.core.service

import com.example.core.dto.UserDto
import io.micronaut.http.HttpResponse

public interface UserService {
    fun saveUser(user: UserDto): HttpResponse<Any>
    fun findAllUsers(): MutableIterable<Any>
}