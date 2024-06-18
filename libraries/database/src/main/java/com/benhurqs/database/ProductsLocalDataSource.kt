package com.benhurqs.database

import androidx.annotation.WorkerThread
import com.benhurqs.database.dao.ProductsDao
import com.benhurqs.database.entities.ProductEntity
import kotlinx.coroutines.flow.Flow

class ProductsLocalDataSource (
    private val productsDao: ProductsDao
) {

    val productList: Flow<List<ProductEntity>> = productsDao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(product: ProductEntity) {
        productsDao.insert(product)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getProduct(id: Int): Flow<ProductEntity?> = productsDao.findById(id)


    suspend fun clear() {
        productsDao.clearTable()
    }

}