package com.su.core_network.retrofit

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitApiFactory {

    private const val BASE_URL = "https://mwz9k.wiremockapi.cloud/"

    private fun createMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(createMoshi()))
        .build()
    
    val koeNaWinApiService = getRetrofit().create(RetrofitKNWNetworkApi::class.java)

}