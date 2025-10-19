package com.LP_Electronica.mapper

import com.LP_Electronica.dto.AddItemDTO
import com.LP_Electronica.dto.ItemDTO
import com.LP_Electronica.entities.Item

object ItemMapper {
    fun Item.toDTO(): ItemDTO{
        return ItemDTO(
            id = id,
            name = name,
            price = price,
            description = description
        )
    }

    fun AddItemDTO.toDTO(): AddItemDTO{
        return AddItemDTO(
            name = name,
            price = price,
            description = description,
            stock = stock
        )
    }

}