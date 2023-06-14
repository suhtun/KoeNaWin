package com.su.core_network.di

import com.su.core_model.IntradayInfoUiData
import com.su.core_network.NetworkDataSource
import com.su.core_network.csv.CSVParser
import com.su.core_network.csv.CompanyListingsParser
import com.su.core_network.csv.IntradayInfoParser
import com.su.core_network.model.NetworkCompanyListing
import com.su.core_network.model.NetworkIntradayInfo
import com.su.core_network.retrofit.RetrofitApiFactory
import com.su.core_network.retrofit.RetrofitStockNetwork
import com.su.core_network.retrofit.api.StockApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    internal fun provideStockApi(): StockApi {
        return RetrofitApiFactory.stockApi
    }

    @Provides
    fun bindCompanyListingsParser(): CSVParser<NetworkCompanyListing> =  CompanyListingsParser()

    @Provides
    fun bindIntradayInfoParser(): CSVParser<NetworkIntradayInfo> = IntradayInfoParser()

    @Provides
    fun provideNetworkDataSource(stockApi: StockApi,  companyListingsParser: CSVParser<NetworkCompanyListing>, intradayInfoParser: CSVParser<NetworkIntradayInfo> ) : NetworkDataSource = RetrofitStockNetwork(stockApi,companyListingsParser,intradayInfoParser)
}