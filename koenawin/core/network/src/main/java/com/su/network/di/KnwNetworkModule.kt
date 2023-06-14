package com.su.network.di

import com.su.network.KnwNetworkApi
import com.su.network.RetrofitKnwApiFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object KnwNetworkModule {

    @Singleton
    @Provides
    internal fun provideStockApi(): KnwNetworkApi {
        return RetrofitKnwApiFactory.knwApiService
    }
}