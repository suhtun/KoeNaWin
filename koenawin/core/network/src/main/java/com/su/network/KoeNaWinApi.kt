package com.su.network

import com.su.network.model.NetworkKoeNaWin
import retrofit2.http.GET

interface KnwNetworkApi {
    @GET(value = "/api/v1/koenawin")
    suspend fun getKoeNaWin(): List<NetworkKoeNaWin>

    companion object{
        const val NETWORK_API = "https://mwz9k.wiremockapi.cloud/"
    }
}

