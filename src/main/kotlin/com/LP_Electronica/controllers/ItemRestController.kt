package com.LP_Electronica.controllers

import com.LP_Electronica.dto.AddItemDTO
import com.LP_Electronica.services.ItemService
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/item")
class ItemRestController (
    private val itemService: ItemService
){


    @GetMapping
    fun getItems(): ResponseEntity<Any> {
        val item = itemService.getItem()
        return if (item.isNotEmpty()) {
            ResponseEntity.ok(item)
        } else {
            ResponseEntity.ok(mapOf("message" to "No hay productos cargados"))
        }
    }

    @PostMapping
    fun register(@RequestBody addItemDTO: AddItemDTO): ResponseEntity<Map<String, String>> {
        itemService.createItem(addItemDTO)
        return ResponseEntity.ok(mapOf("message" to "Producto añadido correctamente"))
    }

    /*@PostMapping
    fun register(@RequestBody addItemDTO: AddItemDTO): ResponseEntity<Any> {
        itemService.createItem(addItemDTO)
        return ResponseEntity.ok(mapOf("message" to "Producto añadido correctamente"))
    }*/

    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: Long): ResponseEntity<Any> {
        return if (itemService.delItem(id)){
            ResponseEntity.ok(mapOf("message" to "Producto eliminado"))
        }else{
            ResponseEntity.ok(mapOf("message" to "Producto no encontrado"))
        }
    }

}