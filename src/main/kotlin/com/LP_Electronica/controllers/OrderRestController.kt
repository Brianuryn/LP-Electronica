package com.LP_Electronica.controllers

import com.LP_Electronica.services.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/order")
class OrderRestController {

    @Autowired
    lateinit var orderService: OrderService

    @GetMapping
    fun getOrder () = orderService.getOrder()

}