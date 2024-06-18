package com.benhurqs.network.base

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseAPI<T> {
    abstract fun getClassType(): Class<T>

    val BASE_URL ="https://fakestoreapi.com/"

    private fun getRetrofit() : Retrofit {

        val client = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .addInterceptor(HttpLoggingInterceptor().apply {
                this.setLevel(HttpLoggingInterceptor.Level.BODY)
            }).build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    var retrofitService: T? = null

    fun getInstance() : T? {
        if (retrofitService == null) {
            retrofitService = getRetrofit().create(getClassType())
        }
        return retrofitService
    }
}