package com.su.core_network

import com.su.core_model.CompanyInfoUiData
import com.su.core_model.CompanyListUiData
import com.su.core_model.IntradayInfoUiData
import com.su.core_network.mock.MockRetrofitStockNetwork
import com.su.core_network.model.asNetwork
import com.su.core_test.MockUtil
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FakeNetworkDataSourceTest {

    private lateinit var dataSource: NetworkDataSource

    @Before
    fun setUp(){
        dataSource = MockRetrofitStockNetwork()
    }

    @Test
    fun test_CompanyListing_Network_Response() = runTest{
        assertEquals(MockUtil.mockCompanyListings().map(CompanyListUiData::asNetwork), dataSource.getCompanyList())
    }

    @Test
    fun test_CompanyInfo_mock_NetworkData() = runTest{
        assertEquals(MockUtil.mockCompanyInfoUiData().let(CompanyInfoUiData::asNetwork), dataSource.getCompanyInfo(""))
    }

    @Test
    fun test_IntradayInfos_mock_NetworkData() = runTest{
        assertEquals(MockUtil.mockIntradayInfos().map(IntradayInfoUiData::asNetwork), dataSource.getIntradayInfo(""))
    }
}