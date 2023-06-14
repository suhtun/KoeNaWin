package com.su.core_network.mock

import com.su.core_model.CompanyInfoUiData
import com.su.core_model.CompanyListUiData
import com.su.core_model.IntradayInfoUiData
import com.su.core_network.NetworkDataSource
import com.su.core_network.model.NetworkCompanyInfo
import com.su.core_network.model.NetworkCompanyListing
import com.su.core_network.model.NetworkIntradayInfo
import com.su.core_network.model.asNetwork
import com.su.core_test.MockUtil

class MockRetrofitStockNetwork: NetworkDataSource {
    override suspend fun getCompanyList(): List<NetworkCompanyListing> {
        return MockUtil.mockCompanyListings().map(CompanyListUiData::asNetwork)
    }

    override suspend fun getIntradayInfo(symbol: String): List<NetworkIntradayInfo> {
        return MockUtil.mockIntradayInfos().map(IntradayInfoUiData::asNetwork)
    }

    override suspend fun getCompanyInfo(symbol: String): NetworkCompanyInfo {
        return MockUtil.mockCompanyInfoUiData().let(CompanyInfoUiData::asNetwork)
    }
}