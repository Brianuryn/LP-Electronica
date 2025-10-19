package com.LP_Electronica.entities

import com.LP_Electronica.enumerations.OrderStatus
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
open class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    val customer: Customer,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.REMOVE], orphanRemoval = true)
    val items: MutableList<OrderItem> = mutableListOf(),

    @Column(nullable = false)
    val orderDate: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var orderPaidCanceledDate: LocalDateTime,

    @Column(nullable = false)
    var totalAmount: Double = 0.0,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var status: OrderStatus = OrderStatus.PENDING
)