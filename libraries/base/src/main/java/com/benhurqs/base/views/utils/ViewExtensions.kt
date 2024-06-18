package com.benhurqs.base.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View

fun Int.inflateView(ctx: Context): View {
    return LayoutInflater.from(ctx)
        .inflate(this, null, false)
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide(){
    this.visibility = View.INVISIBLE
}

fun View.remove(){
    this.visibility = View.GONE
}