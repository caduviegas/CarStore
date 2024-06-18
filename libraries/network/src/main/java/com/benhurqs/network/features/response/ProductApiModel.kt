package com.benhurqs.network.features.response

data class ProductApiModel(
    val id: Int,
    val title: String?,
    val price: Double?,
    val description: String?,
    val category: String?,
    val image: String?,
    val rating: ProductRatingApiModel?
)