package com.example.infrastructure.database.entity

import javax.persistence.*


@Entity
@Table(name = "users")
data class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idUser: Long? = null,
    val name: String,
    val gender: String,
    val documentType: String,
    val documentNumber: String,
    val email: String,
    val phone: Long,
    val address: String
)