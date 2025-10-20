package com.LP_Electronica.dto
// Admin Register Request Data Transfer Object


data class AdminRegRequestDTO (
    val name: String,
    val lastName: String,
    val email: String,
    val password: String,
)