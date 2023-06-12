package com.su.core_localstorage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class KoeNaWinEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "dayString") val dayString: String?,
    @ColumnInfo(name = "gontaw") val gontaw: String?,
    @ColumnInfo(name = "gonetaw_translation") val gontawTranslation: String?,
    @ColumnInfo(name = "show_count") val showCount: String?,
    @ColumnInfo(name = "count") val count: Int
)