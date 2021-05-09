package com.example.infrastructure.database.repository

import com.example.core.outbound.UserRepositoryService
import com.example.infrastructure.database.entity.UserEntity
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl(private val userRepository: UserRepository) : UserRepositoryService {
    override fun saveUser(id: Long?, user: UserEntity): UserEntity {
        return userRepository.saveUser(id, user)
    }

    override fun findAllUsers(): MutableIterable<UserEntity> {
        return userRepository.findAll()
    }


}