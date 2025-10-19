package com.LP_Electronica.mapper

import com.LP_Electronica.dto.OrderItemDTO
import com.LP_Electronica.entities.OrderItem
import com.LP_Electronica.mapper.ItemMapper.toDTO

object OrderItemMapper {
    fun OrderItem.toDTO(): OrderItemDTO{
        return OrderItemDTO(
            item = item.toDTO(),
            quantity = quantity,
            subtotal = subtotal
        )
    }
}