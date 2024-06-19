package com.benhurqs.network

import com.benhurqs.network.features.products.ProductsAPI
import com.benhurqs.network.features.products.ProductsRemoteDataSource
import org.koin.dsl.module

object NetworkModule {
    val instance = module {
        single { ProductsAPI() }
        single { ProductsRemoteDataSource(productsApi = get()) }
    }
}