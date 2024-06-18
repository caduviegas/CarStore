package com.benhurqs.datalayer

import com.benhurqs.database.entities.ProductEntity
import com.benhurqs.network.features.response.ProductApiModel

data class Product(val id: Int,
                   val title: String?,
                   val price: Double?,
                   val description: String?,
                   val category: String?,
                   val image: String?,
                   val rate: Float?,
                   val count: Int
)

fun ProductApiModel.asEntity() = ProductEntity(
    id = id,
    title = title,
    price = price,
    description = description,
    category = category,
    image = image,
    rate = rating?.rate,
    count = rating?.count ?: 0
)

fun ProductEntity.asExternalModel() = Product(
    id = id,
    title = title,
    price = price,
    description = description,
    category = category,
    image = image,
    rate = rate,
    count = count
)
