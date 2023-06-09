package com.su.core_network.retrofit

import com.su.core_network.model.NetworkKoeNaWin
import retrofit2.http.GET

interface RetrofitKNWNetworkApi {
    @GET(value = "/api/v1/koenawin")
    suspend fun getKoeNaWin(): List<NetworkKoeNaWin>
}

