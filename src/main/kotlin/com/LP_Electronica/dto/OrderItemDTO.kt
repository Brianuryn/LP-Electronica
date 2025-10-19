package com.LP_Electronica.dto

data class OrderItemDTO(
    val item: ItemDTO,
    val quantity: Int,
    val subtotal: Double
)