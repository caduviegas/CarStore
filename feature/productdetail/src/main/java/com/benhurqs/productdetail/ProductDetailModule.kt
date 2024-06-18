package com.benhurqs.productdetail

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ProductDetailModule {
    val instance = module {
        viewModel {
            ProductDetailViewModel(
                repository = get())
        }
    }
}