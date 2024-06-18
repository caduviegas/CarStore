package com.benhurqs.carstore

import android.app.Application
import com.benhurqs.productdetail.ProductDetailModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainActivity)

            modules(
                listOf(
                    ProductDetailModule.instance
                )
            )
        }

    }
}