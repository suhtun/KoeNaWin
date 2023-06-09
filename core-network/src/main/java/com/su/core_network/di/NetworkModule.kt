package com.su.core_network.di

import com.su.core_network.retrofit.RetrofitApiFactory
import com.su.core_network.retrofit.RetrofitKNWNetworkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    internal fun provideNetworkService(): RetrofitKNWNetworkApi {
        return RetrofitApiFactory.koeNaWinApiService
    }
}