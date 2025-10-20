package com.LP_Electronica.dto
//Customer Register Request Data Transfer Object

data class CustomerRegRequestDTO(
    val name: String,
    val lastName: String,
    val email: String,
    val password: String,
    val dni: Int,
    val phoneNumber: String?
)