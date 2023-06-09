package com.su.core_data.di

import com.su.core_data.MainRepository
import com.su.core_data.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    fun provideMainRepository(): MainRepository = MainRepositoryImpl()
}