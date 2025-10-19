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
class Customer (
    @Column(nullable = false)
    var dni: Int = 0,

    @Column
    var phoneNumber: String? = null,

    @OneToMany(mappedBy = "customer", cascade = [CascadeType.REMOVE], fetch = FetchType.LAZY)
    var orders: MutableList<Order> = mutableListOf()
) : Users(role = Rol.CUSTOMER)