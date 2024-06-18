package com.benhurqs.datalayer

import com.benhurqs.database.ProductsLocalDataSource
import com.benhurqs.database.entities.ProductEntity
import com.benhurqs.network.features.products.ProductsRemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ProductsRepository(
    private val productsLocalDataSource: ProductsLocalDataSource,
    private val productsRemoteDataSource: ProductsRemoteDataSource,
    private val externalScope: CoroutineScope
) {

    private fun updateAllData(){
        externalScope.launch {
            productsRemoteDataSource.fetchProductList().collectLatest { productList ->
                productList?.let {
                    it.forEach { product -> productsLocalDataSource.insert(product.asEntity()) }
                }
            }
        }
    }

    suspend fun getProductDetail(productId: Int): Flow<Product?> {
        return productsLocalDataSource.getProduct(productId).map {
            it?.asExternalModel()
        }
    }

    fun getProductList(): Flow<List<Product>?> {
        updateAllData()
        return productsLocalDataSource.productList.map {
            it.map(ProductEntity::asExternalModel)
        }
    }
}