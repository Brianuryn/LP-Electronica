package com.LP_Electronica.controllers

import com.LP_Electronica.dto.RegisterRequestDTO
import com.LP_Electronica.services.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customer")
class CustomerRestController (
    private val customerService: CustomerService
) {

    @GetMapping
    fun getCustomers(): ResponseEntity<Any> {
        val customers = customerService.getCustomers()
        return if (customers.isNotEmpty()) {
            ResponseEntity.ok(customers)
        } else {
            ResponseEntity.ok(mapOf("message" to "No hay clientes cargados"))
        }
    }

    /*fun getCustomers(): List<CustomerDTO> = customerService.getCustomers()*/

    @PostMapping
    fun register(@RequestBody registerRequestDTO: RegisterRequestDTO): ResponseEntity<String> {
        customerService.createCustomer(registerRequestDTO)

        return ResponseEntity.ok("Usuario registrado correctamente")
    }

}