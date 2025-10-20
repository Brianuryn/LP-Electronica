package com.LP_Electronica.services

import com.LP_Electronica.dto.AdminRegRequestDTO
import com.LP_Electronica.entities.Admin
import com.LP_Electronica.mapper.AdminMapper.toDTO
import com.LP_Electronica.repository.AdminRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AdminService(
    private val adminRepository: AdminRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun getAdmin() = adminRepository.findAll().map { it.toDTO() }

    fun createAdmin(adminRegRequestDTO: AdminRegRequestDTO){
        val admin = Admin().apply {
            name = adminRegRequestDTO.name
            lastName = adminRegRequestDTO.lastName
            email = adminRegRequestDTO.email
            password = passwordEncoder.encode(adminRegRequestDTO.password)
        }
        adminRepository.save(admin)

    }

    fun editAdmin(adminRegRequestDTO: AdminRegRequestDTO, id : Long) : Boolean{
        val auxAdmin = adminRepository.findById(id)
        if (auxAdmin.isPresent) {
            val item = auxAdmin.get().apply {
                name = adminRegRequestDTO.name
                lastName = adminRegRequestDTO.lastName
                email = adminRegRequestDTO.email
                password = passwordEncoder.encode(adminRegRequestDTO.password)
            }
            adminRepository.save(item)
            return true
        }
        return false
    }

    /*fun editAdminName(adminRegRequestDTO: AdminRegRequestDTO, id : Long) : Boolean{
        val auxAdmin = adminRepository.findById(id)
        if (auxAdmin.isPresent) {
            val item = auxAdmin.get().apply {
                name = adminRegRequestDTO.name
                lastName = adminRegRequestDTO.lastName
            }
            adminRepository.save(item)
            return true
        }
        return false
    }

    fun editAdminES(adminRegRequestDTO: AdminRegRequestDTO, id : Long) : Boolean{
        val auxAdmin = adminRepository.findById(id)
        if (auxAdmin.isPresent) {
            val item = auxAdmin.get().apply {
                email = adminRegRequestDTO.email
                password = passwordEncoder.encode(adminRegRequestDTO.password)
            }
            adminRepository.save(item)
            return true
        }
        return false
    }*/

    fun disableAdmin(id: Long): Boolean{
        val auxAdmin = adminRepository.findById(id)
        if (auxAdmin.isPresent) {
            val admin = auxAdmin.get().apply {
                status = false
            }
            adminRepository.save(admin)
            return true
        }
        return false
    }

    fun delAdmin(id: Long): Boolean{
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id)
            return true
        } else {
            return false
        }
    }


}