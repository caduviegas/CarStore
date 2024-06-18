package com.benhurqs.base.actions

import android.content.Context
import android.content.Intent

object Actions {
    const val PRODUCT_ID_KEY = "product.id"

    private fun internalIntent(context: Context?, action: String) = Intent(action).setPackage(context?.packageName)

    fun openProductDetail(context: Context, productId: Int) {
        val intent = internalIntent(context, "benhurqs.action.product.detail.open")
        intent.putExtra(PRODUCT_ID_KEY, productId)
        context.startActivity(intent)
    }
}