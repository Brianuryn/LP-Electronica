package com.LP_Electronica.controllers

import com.LP_Electronica.dto.RegisterRequestDTO
import com.LP_Electronica.services.AdminService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/admin")
class AdminRestController(
    private val adminService: AdminService
) {

    @GetMapping
    fun getAdmins(): ResponseEntity<Any> {
        val admins = adminService.getAdmin()
        return if (admins.isNotEmpty()) {
            ResponseEntity.ok(admins)
        } else {
            ResponseEntity.ok(mapOf("message" to "No hay administradores cargados"))
        }
    }

    @PostMapping
    fun register(@RequestBody registerRequestDTO: RegisterRequestDTO): ResponseEntity<String> {
        adminService.createAdmin(registerRequestDTO)
        return ResponseEntity.ok("Administrador registrado correctamente")
    }


}