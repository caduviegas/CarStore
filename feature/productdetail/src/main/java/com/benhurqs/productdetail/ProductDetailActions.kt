package com.benhurqs.productdetail

import com.benhurqs.datalayer.Product


sealed class ProductDetailActions {
    object ShowError: ProductDetailActions()
    data class LoadProduct(val product: Product): ProductDetailActions()
}