package com.su.core_network.model

import com.su.core_model.CompanyListUiData

data class NetworkCompanyListing( val name: String,
                                  val symbol: String,
                                  val exchange: String,)

fun CompanyListUiData.asNetwork() = NetworkCompanyListing(name=name,symbol=symbol,exchange=exchange)


