package com.LP_Electronica.services

import com.LP_Electronica.dto.RegisterRequestDTO
import com.LP_Electronica.entities.Customer
import com.LP_Electronica.mapper.CustomerMapper.toDTO
import com.LP_Electronica.repository.CustomerRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun getCustomers() = customerRepository.findAll().map { it.toDTO() }

    fun createCustomer(registerRequestDTO: RegisterRequestDTO){
        val customer = Customer().apply {
            dni = registerRequestDTO.dni
            phoneNumber = registerRequestDTO.phoneNumber
            name = registerRequestDTO.name
            lastName = registerRequestDTO.lastName
            email = registerRequestDTO.email
            password = passwordEncoder.encode(registerRequestDTO.password)
        }
        customerRepository.save(customer)
    }

}