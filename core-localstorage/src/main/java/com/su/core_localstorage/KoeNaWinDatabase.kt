package com.su.core_localstorage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.su.core_localstorage.entity.KoeNaWinEntity

@Database(entities = [KoeNaWinEntity::class], version = 1)
abstract class KoeNaWinDatabase : RoomDatabase() {
    abstract fun koeNaWinDao(): KoeNaWinDao
}