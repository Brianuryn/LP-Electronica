package com.LP_Electronica.repository


import com.LP_Electronica.entities.Admin
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AdminRepository : JpaRepository<Admin, Long>{

}