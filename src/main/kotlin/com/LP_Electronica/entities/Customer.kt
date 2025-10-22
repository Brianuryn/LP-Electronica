package com.LP_Electronica.entities

import com.LP_Electronica.enumerations.Rol
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "customer")
class Customer(
    @Column(nullable = false)
    var dni: Int,

    @Column
    var phoneNumber: String? = null,

    @OneToMany(mappedBy = "customer", cascade = [CascadeType.REMOVE], fetch = FetchType.LAZY)
    var orders: MutableList<Order> = mutableListOf(),

    name: String,
    lastName: String,
    email: String,
    password: String

) : Users(
    role = Rol.CUSTOMER,
    name = name,
    lastName = lastName,
    email = email,
    password = password
)