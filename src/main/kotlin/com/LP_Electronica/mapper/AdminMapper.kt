package com.LP_Electronica.mapper

import com.LP_Electronica.dto.AdminDTO
import com.LP_Electronica.entities.Admin


public object AdminMapper {

    fun Admin.toDTO(): AdminDTO {
        return AdminDTO(
            id = id,
            name = name,
            lastName = lastName,
            email = email
        )
    }

}