package com.LP_Electronica.services

import com.LP_Electronica.mapper.OrderMapper.toDTO
import com.LP_Electronica.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderService (
    val orderRepository: OrderRepository
) {

    fun getOrder () = orderRepository.findAll().map { it.toDTO() }

}