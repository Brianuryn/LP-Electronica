package com.LP_Electronica.mapper

import com.LP_Electronica.dto.CustomerDTO
import com.LP_Electronica.dto.CustomerRegRequestDTO
import com.LP_Electronica.entities.Customer

object CustomerMapper {

    fun Customer.toDTO(): CustomerDTO {
        return CustomerDTO(
            id = id,
            name = name,
            lastName = lastName,
            email = email,
            dni = dni,
            phoneNumber = phoneNumber
        )
    }

    fun Customer.registerToDTO(): CustomerRegRequestDTO{
        return CustomerRegRequestDTO(
            name = name,
            lastName = lastName,
            email = email,
            password = password,
            dni = dni,
            phoneNumber = phoneNumber
        )
    }

}