package com.LP_Electronica.dto

import com.LP_Electronica.enumerations.OrderStatus
import java.time.LocalDateTime

class OrderDTO (
    val id: Long?,
    val orderDate: LocalDateTime,
    val orderPaidCanceledDate: LocalDateTime,
    val totalAmount: Double,
    val items : List<OrderItemDTO>,
    val status: OrderStatus
)