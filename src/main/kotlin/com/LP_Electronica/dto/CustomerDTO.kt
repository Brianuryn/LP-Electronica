package com.LP_Electronica.dto

data class CustomerDTO(
    val id: Long?,
    val name: String,
    val lastName: String,
    val email: String,
    val dni: Int,
    val phoneNumber: String?
)