package com.su.core_data.model

import com.su.core_localstorage.stockmarket.CompanyListingEntity
import com.su.core_model.CompanyListUiData
import com.su.core_network.model.NetworkCompanyListing

fun NetworkCompanyListing.asUiModel() = CompanyListUiData(name=name,symbol=symbol,exchange=exchange)

fun CompanyListUiData.asEntity() = CompanyListingEntity(name=name,symbol=symbol,exchange=exchange)

fun CompanyListingEntity.asUiModel() = CompanyListUiData(name=name,symbol=symbol,exchange=exchange)
