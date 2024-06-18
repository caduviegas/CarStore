package com.benhurqs.base.views.utils

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import java.text.NumberFormat
import java.util.*

fun String.loadImageInto(context: Context, imageView: AppCompatImageView){
    Glide.with(context)
        .load(this)
        .fitCenter()
        .into(imageView)
}

fun Number.formatPrice(): String{
    val loc = Locale("pt", "BR")
    val nf = NumberFormat.getCurrencyInstance(loc)
    var symbol: String? = null
    val currency = nf.currency

    if (currency != null) {
        symbol = currency.symbol
    }

    var formattedSTR = nf.format(this)
    if (symbol != null && !symbol.isNullOrBlank() && !symbol.contains(" ")) {
        formattedSTR = formattedSTR.replace(symbol, "$symbol")
    }

    return formattedSTR
}