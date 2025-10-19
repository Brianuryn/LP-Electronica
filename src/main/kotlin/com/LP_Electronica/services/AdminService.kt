package com.LP_Electronica.services

import com.LP_Electronica.dto.RegisterRequestDTO
import com.LP_Electronica.entities.Admin
import com.LP_Electronica.mapper.AdminMapper.toDTO
import com.LP_Electronica.repository.AdminRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AdminService(
    private val adminRepository: AdminRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun getAdmin() = adminRepository.findAll().map { it.toDTO() }

    fun createAdmin(registerRequestDTO: RegisterRequestDTO){
        val admin = Admin().apply {
            name = registerRequestDTO.name
            lastName = registerRequestDTO.lastName
            email = registerRequestDTO.email
            password = passwordEncoder.encode(registerRequestDTO.password)
        }
        adminRepository.save(admin)

    }


}