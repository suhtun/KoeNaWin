package com.su.core_network

import com.su.core_model.CompanyInfoUiData
import com.su.core_model.IntradayInfoUiData
import com.su.core_network.model.NetworkCompanyInfo
import com.su.core_network.model.NetworkCompanyListing
import kotlinx.coroutines.flow.Flow

interface NetworkDataSource {
    suspend fun getCompanyList(): List<NetworkCompanyListing>

    suspend fun getIntradayInfo(
        symbol: String
    ): List<IntradayInfoUiData>

    suspend fun getCompanyInfo(
        symbol: String
    ): NetworkCompanyInfo
}