package com.benhurqs.network.features.products

import com.benhurqs.network.features.response.ProductApiModel
import kotlinx.coroutines.flow.Flow

class ProductsRemoteDataSource (
    private val productsApi: ProductsAPI,
) {
    fun fetchProductList(): Flow<List<ProductApiModel>?> = productsApi.getProductList()

}