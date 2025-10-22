package com.LP_Electronica.services

import com.LP_Electronica.dto.CustomerRegRequestDTO
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

    fun createCustomer(dto: CustomerRegRequestDTO) {
        val customer = Customer(
            dni = dto.dni,
            phoneNumber = dto.phoneNumber,
            name = dto.name,
            lastName = dto.lastName,
            email = dto.email,
            password = passwordEncoder.encode(dto.password)
        )
        customerRepository.save(customer)
    }

}