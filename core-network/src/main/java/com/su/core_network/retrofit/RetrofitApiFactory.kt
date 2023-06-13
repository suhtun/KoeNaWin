package com.su.core_network.retrofit

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.su.core_network.retrofit.api.RetrofitKNWNetworkApi
import com.su.core_network.retrofit.api.StockApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitApiFactory {

    private const val BASE_URL = "https://mwz9k.wiremockapi.cloud/"

    private fun createMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private fun getRetrofit(url:String): Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(MoshiConverterFactory.create(createMoshi()))
        .client(
            OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }).build())
        .build()
    
    val koeNaWinApiService = getRetrofit(BASE_URL).create(RetrofitKNWNetworkApi::class.java)

    val stockApi = getRetrofit(StockApi.BASE_URL).create(StockApi::class.java)

}