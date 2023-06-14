package com.su.core_network.model

import com.squareup.moshi.Json
import com.su.core_model.CompanyInfoUiData


data class NetworkCompanyInfo(
    @field:Json(name = "Symbol") val symbol: String?,
    @field:Json(name = "Description") val description: String?,
    @field:Json(name = "Name") val name: String?,
    @field:Json(name = "Country") val country: String?,
    @field:Json(name = "Industry") val industry: String?,
)

fun CompanyInfoUiData.asNetwork() = NetworkCompanyInfo(symbol=symbol,description=description,name=name,country=country,industry=industry)

