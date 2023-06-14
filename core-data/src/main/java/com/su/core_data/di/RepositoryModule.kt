package com.su.core_data.di

import com.su.core_data.repository.koenawin.MainRepository
import com.su.core_data.repository.koenawin.MainRepositoryImpl
import com.su.core_data.repository.stockmarket.StockMarketMainRepository
import com.su.core_data.repository.stockmarket.StockMarketMianRepositoryImpl
import com.su.core_localstorage.KoeNaWinDao
import com.su.core_localstorage.stockmarket.StockDao
import com.su.core_network.NetworkDataSource
import com.su.network.KnwNetworkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideMainRepository(network: KnwNetworkApi, koeNaWinDao: KoeNaWinDao): MainRepository = MainRepositoryImpl(network,koeNaWinDao)


    @Provides
    fun provideStockMarketMainRepository(dataSource: NetworkDataSource,stockDao: StockDao): StockMarketMainRepository
    = StockMarketMianRepositoryImpl(dataSource,stockDao)
}