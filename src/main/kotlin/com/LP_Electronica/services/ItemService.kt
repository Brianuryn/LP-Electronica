package com.LP_Electronica.services

import com.LP_Electronica.dto.AddItemDTO
import com.LP_Electronica.entities.Item
import com.LP_Electronica.mapper.ItemMapper.toDTO
import com.LP_Electronica.repository.ItemRepository
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val itemRepository: ItemRepository
) {

    fun getItem () = itemRepository.findAll().map { it.toDTO() }

    fun createItem (addItemDTO: AddItemDTO){
        val item = Item ().apply {
            name = addItemDTO.name
            price = addItemDTO.price
            description = addItemDTO.description
            stock = addItemDTO.stock
        }
        itemRepository.save(item)
    }

    fun editItem(addItemDTO: AddItemDTO, id: Long): Boolean {
        val auxItem = itemRepository.findById(id)
        if (auxItem.isPresent) {
            val item = auxItem.get().apply {
                name = addItemDTO.name
                price = addItemDTO.price
                description = addItemDTO.description
                stock = addItemDTO.stock
            }
            itemRepository.save(item)
            return true
        }
        return false
    }


    /*fun delItem(id: Long): Boolean {
        return try {
            itemRepository.deleteById(id)
            true
        } catch (ex: EmptyResultDataAccessException) {
            false
        }
    }
*/

    fun delItem(id: Long): Boolean{
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id)
            return true
        } else {
            return false
        }
    }

}