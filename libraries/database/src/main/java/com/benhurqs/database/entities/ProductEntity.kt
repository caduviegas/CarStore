package com.benhurqs.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey val id: Int,
    val title: String?,
    val price: Double?,
    val description: String?,
    val category: String?,
    val image: String?,
    val rate: Float?,
    val count: Int
)