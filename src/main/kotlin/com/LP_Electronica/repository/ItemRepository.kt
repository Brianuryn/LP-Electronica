package com.LP_Electronica.repository

import com.LP_Electronica.entities.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ItemRepository : JpaRepository<Item, Long>{

}