package com.benhurqs.datalayer

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

object DataLayerModule {
    val instance = module {
        factory { CoroutineScope(Dispatchers.IO) }

        single {
            ProductsRepository(
                productsRemoteDataSource = get(),
                externalScope = get()
            )
        }
    }
}