package com.LP_Electronica.dto

data class RegisterRequestDTO(
    val name: String,
    val lastName: String,
    val email: String,
    val password: String,
    val dni: Int,
    val phoneNumber: String?
)