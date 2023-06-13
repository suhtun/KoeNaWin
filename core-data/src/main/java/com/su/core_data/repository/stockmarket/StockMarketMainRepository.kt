package com.su.core_data.repository.stockmarket

import com.su.core_model.CompanyInfoUiData
import com.su.core_model.CompanyListUiData
import com.su.core_model.IntradayInfoUiData
import kotlinx.coroutines.flow.Flow

interface StockMarketMainRepository {
    fun getCompanyList(query: String): Flow<List<CompanyListUiData>>

    fun getIntradayInfo(
        symbol: String
    ): Flow<List<IntradayInfoUiData>>

    fun getCompanyInfo(
        symbol: String
    ): Flow<CompanyInfoUiData>
}