package com.su.core_localstorage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.su.core_localstorage.entity.KoeNaWinEntity

@Dao
interface KoeNaWinDao {
    @Query("SELECT * FROM KoeNaWinEntity")
    fun getAll():List<KoeNaWinEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertKoeNaWins(koeNaWin: List<KoeNaWinEntity>)
}