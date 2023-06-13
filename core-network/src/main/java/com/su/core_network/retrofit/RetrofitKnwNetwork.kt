package com.su.core_network.retrofit

import com.su.core_model.CompanyInfoUiData
import com.su.core_model.IntradayInfoUiData
import com.su.core_network.NetworkDataSource
import com.su.core_network.csv.CSVParser
import com.su.core_network.model.NetworkCompanyInfo
import com.su.core_network.model.NetworkCompanyListing
import com.su.core_network.retrofit.api.StockApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitKnwNetwork @Inject constructor(
    private val stockApi: StockApi,
    private val companyListingsParser: CSVParser<NetworkCompanyListing>,
    private val intradayInfoParser: CSVParser<IntradayInfoUiData>,
) : NetworkDataSource {
    override suspend fun getCompanyList(): List<NetworkCompanyListing> {
        val response = stockApi.getListings()
        return companyListingsParser.parse(response.byteStream())
    }

    override suspend fun getIntradayInfo(symbol: String): List<IntradayInfoUiData> {
        val response = stockApi.getIntradayInfo(symbol)
        return intradayInfoParser.parse(response.byteStream())
    }

    //todo: still need to follow up regarding response
    override suspend fun getCompanyInfo(symbol: String): NetworkCompanyInfo {
        val response = stockApi.getCompanyInfo(symbol)
        return response
    }
}