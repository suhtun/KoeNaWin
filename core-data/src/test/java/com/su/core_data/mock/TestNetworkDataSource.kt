package com.su.core_data.mock

import com.su.core_data.model.asNetwork
import com.su.core_model.CompanyInfoUiData
import com.su.core_model.CompanyListUiData
import com.su.core_model.IntradayInfoUiData
import com.su.core_network.NetworkDataSource
import com.su.core_network.model.NetworkCompanyInfo
import com.su.core_network.model.NetworkCompanyListing
import com.su.core_test.MockUtil

class TestNetworkDataSource : NetworkDataSource {
    override suspend fun getCompanyList(): List<NetworkCompanyListing> {
        return MockUtil.mockCompanyListings().map(CompanyListUiData::asNetwork)
    }

    override suspend fun getIntradayInfo(symbol: String): List<IntradayInfoUiData> {
        return listOf(MockUtil.mockIntradayInfo())
    }

    override suspend fun getCompanyInfo(symbol: String): NetworkCompanyInfo {
        return MockUtil.mockCompanyInfoUiData().let(CompanyInfoUiData::asNetwork)
    }
}