package com.example.controller

import com.example.core.dto.ResponseApi
import com.example.core.dto.UserDto
import com.example.core.service.UserService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import org.slf4j.LoggerFactory
import javax.inject.Inject

@Controller("v1/api/users")
class UserController {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Inject
    lateinit var userService: UserService

    @Get("/")
    fun getAllUsers(): ResponseApi<MutableIterable<Any>> {
        return ResponseApi(200, userService.findAllUsers())
    }

    @Get("/{id}")
    fun getUser(id: Int): HttpResponse<Any> {
        return HttpResponse.ok<Any>().body("{\"user\":123}")
    }

    @Post
    fun createUser(@Body() user: UserDto): HttpResponse<Any> {
        logger.info("Params $user")
        return userService.saveUser(user)
    }

    @Put("/{id}")
    fun updateUser(id: Int): HttpResponse<Any> {
        return HttpResponse.ok<Any>().body("{\"user\":123}")
    }

    @Delete("/{id}")
    fun deleteUser(id: Int): HttpResponse<Any> {
        return HttpResponse.ok<Any>().body("{\"user\":123}")
    }
}