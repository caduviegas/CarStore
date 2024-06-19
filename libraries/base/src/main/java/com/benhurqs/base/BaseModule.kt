package com.benhurqs.base

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object BaseModule {
    val instance = module {
//        single { MainPreferences(androidContext()) }
//        single { AuthPreferences(get()) }
    }
}