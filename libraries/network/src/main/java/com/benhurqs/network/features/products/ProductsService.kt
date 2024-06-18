package com.benhurqs.network.features.products

import com.benhurqs.network.features.response.ProductApiModel
import retrofit2.http.GET

interface ProductsService {
    @GET("products")
    suspend fun getProductList(): List<ProductApiModel>?
}