package com.su.core_localstorage.di

import android.app.Application
import androidx.room.Room
import com.su.core_localstorage.KoeNaWinDao
import com.su.core_localstorage.KoeNaWinDatabase
import com.su.core_localstorage.stockmarket.StockDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): KoeNaWinDatabase =
        Room.databaseBuilder(application, KoeNaWinDatabase::class.java, "koenawin.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideKoeNaWinDao(database: KoeNaWinDatabase): KoeNaWinDao{
        return database.koeNaWinDao()
    }

    @Provides
    @Singleton
    fun provideStockDao(database: KoeNaWinDatabase): StockDao{
        return database.StockDao()
    }

}