package com.example.core.service

import com.example.core.dto.UserDto
import com.example.core.outbound.UserRepositoryService
import com.example.core.util.Mapper
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class UserServiceImpl(private val userRepositoryService: UserRepositoryService, private val mapper: Mapper) :
    UserService {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun saveUser(user: UserDto): HttpResponse<Any> {
        val entity = userRepositoryService.saveUser(null, mapper.dtoToEntity(user))
        logger.info("ENTITY $entity")
        return HttpResponse.status<Any>(HttpStatus.OK).body(entity)
    }

    override fun findAllUsers(): MutableIterable<Any> {
        return userRepositoryService.findAllUsers()
    }
}