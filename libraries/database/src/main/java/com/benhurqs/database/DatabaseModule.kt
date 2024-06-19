package com.benhurqs.database

import com.benhurqs.database.dao.ProductsDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object DatabaseModule {

    val instance = module {

        single {
            val database by lazy { ProductDatabase.getDatabase(androidContext()) }
            database.productDao()
        }

//        single<ProductsDao> {
//            val database = get<ProductDatabase>()
//            database.productDao()
//        }

        single { ProductsLocalDataSource(
            productsDao = get()
        ) }
    }
}