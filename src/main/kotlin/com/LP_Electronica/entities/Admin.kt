package com.LP_Electronica.entities

import com.LP_Electronica.enumerations.Rol
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "admin")
class Admin : Users(role = Rol.ADMIN){
}