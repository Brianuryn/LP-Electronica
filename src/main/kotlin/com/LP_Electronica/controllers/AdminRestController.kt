package com.LP_Electronica.controllers

import com.LP_Electronica.dto.AdminRegRequestDTO
import com.LP_Electronica.services.AdminService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    fun register(@RequestBody adminRegRequestDTO: AdminRegRequestDTO): ResponseEntity<String> {
        adminService.createAdmin(adminRegRequestDTO)
        return ResponseEntity.ok("Administrador registrado correctamente")
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    fun editAdmin (@RequestBody adminRegRequestDTO: AdminRegRequestDTO, @PathVariable id : Long): ResponseEntity<Map<String, String>?> {
        return if (adminService.editAdmin(adminRegRequestDTO,id)){
            ResponseEntity.ok(mapOf("message" to "Administrador actualizado"))
        }else{
            ResponseEntity.ok(mapOf("message" to "Administrador no encontrado"))
        }
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/disable/{id}")
    fun disableAdmin (@PathVariable id : Long): ResponseEntity<Map<String, String>?> {
        return if (adminService.disableAdmin(id)){
            ResponseEntity.ok(mapOf("message" to "Administrador deshabilitado"))
        }else{
            ResponseEntity.ok(mapOf("message" to "Administrador no encontrado"))
        }
    }

    //@PreAuthorize("hasRole('ADMIN')")
    fun deleteAdmin (@PathVariable id: Long): ResponseEntity<Map<String, String>?> {
        return if (adminService.delAdmin(id)){
            ResponseEntity.ok(mapOf("message" to "Administrador eliminado"))
        }else{
            ResponseEntity.ok(mapOf("message" to "Administrador no encontrado"))
        }
    }
}