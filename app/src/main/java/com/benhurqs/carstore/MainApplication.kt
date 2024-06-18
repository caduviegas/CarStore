package com.benhurqs.carstore

import android.app.Application
import com.benhurqs.datalayer.DataLayerModule
import com.benhurqs.productdetail.ProductDetailModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)

            modules(
                listOf(
                    ProductDetailModule.instance,
                    DataLayerModule.instance
                )
            )
        }

    }
}