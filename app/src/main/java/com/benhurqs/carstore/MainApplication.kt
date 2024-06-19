package com.benhurqs.carstore

import android.app.Application
import com.benhurqs.base.BaseModule
import com.benhurqs.database.DatabaseModule
import com.benhurqs.datalayer.DataLayerModule
import com.benhurqs.network.NetworkModule
import com.benhurqs.productdetail.ProductDetailModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)

            modules(
                listOf(
                    NetworkModule.instance,
                    BaseModule.instance,
                    DatabaseModule.instance,
                    DataLayerModule.instance,
                    ProductDetailModule.instance
                )
            )
        }

    }

}