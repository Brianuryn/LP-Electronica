package com.LP_Electronica.entities

import com.LP_Electronica.enumerations.Rol
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "admin")
class Admin(

    name: String,
    lastName: String,
    email: String,
    password: String

) : Users(
    role = Rol.ADMIN,
    name = name,
    lastName = lastName,
    email = email,
    password = password
)