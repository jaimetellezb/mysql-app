package com.example.infrastructure.database.repository

import com.example.infrastructure.database.entity.UserEntity
import io.micronaut.data.annotation.Id
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@JdbcRepository(
    dialect = Dialect.MYSQL
)
interface UserRepository : CrudRepository<UserEntity, Long> {
    fun saveUser(@Id id: Long?, user: UserEntity): UserEntity
}