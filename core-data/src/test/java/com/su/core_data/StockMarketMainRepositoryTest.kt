package com.su.core_data

import com.su.core_data.model.asUiModel
import com.su.core_data.repository.stockmarket.StockMarketMainRepository
import com.su.core_data.repository.stockmarket.StockMarketMianRepositoryImpl
import com.su.core_data.mock.TestNetworkDataSource
import com.su.core_data.mock.TestStockDao
import com.su.core_localstorage.stockmarket.CompanyListingEntity
import com.su.core_localstorage.stockmarket.StockDao
import com.su.core_network.NetworkDataSource
import com.su.core_test.MockUtil
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class StockMarketMainRepositoryTest {
    private lateinit var repository: StockMarketMainRepository
    private lateinit var dataSource: NetworkDataSource
    private lateinit var stockDao: StockDao

    @Before
    fun setup() {
        dataSource = TestNetworkDataSource()
        stockDao = TestStockDao()
        repository = StockMarketMianRepositoryImpl(dataSource, stockDao)
    }

    @Test
    fun CompanyListing_is_backed_by_StockDao() = runTest {
        Assert.assertEquals(
                stockDao.getAllCompanyList()
                    .map(CompanyListingEntity::asUiModel),
                repository.getCompanyList("AA").first()
            )
        }

    @Test
    fun IntradayInfo_is_backed_by_network() = runTest {
        Assert.assertEquals(MockUtil.mockIntradayInfos(), repository.getIntradayInfo("AA").first())
    }

    @Test
    fun CompanInfo_is_backed_by_network() = runTest {
        Assert.assertEquals(MockUtil.mockCompanyInfoUiData(), repository.getCompanyInfo("").first())
    }

}