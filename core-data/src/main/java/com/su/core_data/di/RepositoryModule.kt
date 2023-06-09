package com.su.core_data.di

import com.su.core_data.MainRepository
import com.su.core_data.MainRepositoryImpl
import com.su.core_network.retrofit.RetrofitKNWNetworkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideMainRepository(network: RetrofitKNWNetworkApi): MainRepository = MainRepositoryImpl(network)
}