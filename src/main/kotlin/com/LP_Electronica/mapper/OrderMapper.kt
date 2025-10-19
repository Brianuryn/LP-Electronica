package com.LP_Electronica.mapper

import com.LP_Electronica.dto.OrderDTO
import com.LP_Electronica.entities.Order
import com.LP_Electronica.mapper.OrderItemMapper.toDTO


object OrderMapper {

    fun Order.toDTO(): OrderDTO{
        return OrderDTO(
            id = id,
            orderDate = orderDate,
            orderPaidCanceledDate = orderPaidCanceledDate,
            totalAmount = totalAmount,
            status = status,
            items = items.map { it.toDTO() }
        )
    }

}