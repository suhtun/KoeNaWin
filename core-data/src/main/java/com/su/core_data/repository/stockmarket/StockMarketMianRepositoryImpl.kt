package com.su.core_data.repository.stockmarket

import com.su.core_data.model.asEntity
import com.su.core_data.model.asUiModel
import com.su.core_localstorage.stockmarket.CompanyListingEntity
import com.su.core_localstorage.stockmarket.StockDao
import com.su.core_model.CompanyInfoUiData
import com.su.core_model.CompanyListUiData
import com.su.core_model.IntradayInfoUiData
import com.su.core_network.NetworkDataSource
import com.su.core_network.model.NetworkCompanyInfo
import com.su.core_network.model.NetworkCompanyListing
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockMarketMianRepositoryImpl @Inject constructor(
    val dataSource: NetworkDataSource,
    val stockDao: StockDao
) :
    StockMarketMainRepository {
    override fun getCompanyList(query: String): Flow<List<CompanyListUiData>> = flow {
        var offlineLists = stockDao.searchCompanyListing(query).map(CompanyListingEntity::asUiModel)

        if (offlineLists.isNullOrEmpty()) {
            val response = dataSource.getCompanyList().map(NetworkCompanyListing::asUiModel)
            offlineLists = response
            stockDao.insertCompanyListings(response.map(CompanyListUiData::asEntity))
        }
        emit(offlineLists)
    }.flowOn(Dispatchers.IO)

    override fun getIntradayInfo(symbol: String): Flow<List<IntradayInfoUiData>> = flow {
        val response = dataSource.getIntradayInfo(symbol)
        emit(response)
    }.flowOn(Dispatchers.IO)

    override fun getCompanyInfo(symbol: String): Flow<CompanyInfoUiData> = flow {
        val response = dataSource.getCompanyInfo(symbol).asUiModel()
        emit(response)
    }.flowOn(Dispatchers.IO)
}