package com.su.core_localstorage.stockmarket

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.su.core_model.CompanyListUiData

@Entity
data class CompanyListingEntity(
    val name: String,
    val symbol: String,
    val exchange: String,
    @PrimaryKey val id: Int? = null
)

fun CompanyListUiData.asEntity() =
    CompanyListingEntity(name = name, symbol = symbol, exchange = exchange, id = id)