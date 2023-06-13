package com.su.core_localstorage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.su.core_localstorage.entity.KoeNaWinEntity
import com.su.core_localstorage.stockmarket.CompanyListingEntity
import com.su.core_localstorage.stockmarket.StockDao

@Database(entities = [KoeNaWinEntity::class, CompanyListingEntity::class], version = 1)
abstract class KoeNaWinDatabase : RoomDatabase() {
    abstract fun koeNaWinDao(): KoeNaWinDao

    abstract fun StockDao(): StockDao
}