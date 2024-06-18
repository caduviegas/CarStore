package com.benhurqs.network.features.products

import com.benhurqs.network.base.BaseAPI
import kotlinx.coroutines.flow.flow

class ProductsAPI: BaseAPI<ProductsService>() {
    override fun getClassType() = ProductsService::class.java
    fun getProductList() = flow {
        emit(getInstance()?.getProductList())
    }
}