package com.LP_Electronica.dto

data class AddItemDTO(
    val name: String,
    val price: Double,
    val description: String,
    val stock : Int
)