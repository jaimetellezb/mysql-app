package com.example.core.outbound

import com.example.infrastructure.database.entity.UserEntity

public interface UserRepositoryService {
    fun saveUser(id: Long?, user: UserEntity): UserEntity
    fun findAllUsers(): MutableIterable<UserEntity>
}