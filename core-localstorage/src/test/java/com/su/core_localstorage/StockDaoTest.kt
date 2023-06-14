package com.su.core_localstorage


import com.su.core_localstorage.stockmarket.StockDao
import com.su.core_localstorage.stockmarket.asEntity
import com.su.core_model.CompanyListUiData
import com.su.core_test.MockUtil
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.hamcrest.core.Is.`is`

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [23])
class StockDaoTest : LocalDatabaseTest(){
    private lateinit var stockDao: StockDao

    @Before
    fun init(){
        stockDao = database.StockDao()
    }

    @Test
    fun insertAndLoadCompanyListing()= runBlocking{
        val mockCompanyListing = MockUtil.mockCompanyListings().map(CompanyListUiData::asEntity)
        stockDao.insertCompanyListings(mockCompanyListing)

        val loadFromDatabase = stockDao.searchCompanyListing("")
        MatcherAssert.assertThat(loadFromDatabase.toString(), `is`(mockCompanyListing.toString()))

        val firstIndex = mockCompanyListing[0]
        MatcherAssert.assertThat(loadFromDatabase[0], `is`(firstIndex))
    }

    @Test
    fun searchCompanyListing() = runBlocking {
        val mockCompanyListing = MockUtil.mockCompanyListings().map(CompanyListUiData::asEntity)
        stockDao.insertCompanyListings(mockCompanyListing)

        val searchFromDatabase = stockDao.searchCompanyListing("AA")
        MatcherAssert.assertThat(searchFromDatabase.toString(), `is`(mockCompanyListing.toString()))
    }

    @Test
    fun insertAndClearCompanyListing() = runBlocking {
        val mockCompanyListing = MockUtil.mockCompanyListings().map(CompanyListUiData::asEntity)
        stockDao.insertCompanyListings(mockCompanyListing)


        val loadFromDatabase = stockDao.getAllCompanyList()
        MatcherAssert.assertThat(loadFromDatabase.toString(), `is`(mockCompanyListing.toString()))

        stockDao.clearCompanyListings()
        val loadAfterClearedData = stockDao.getAllCompanyList()

        MatcherAssert.assertThat(loadAfterClearedData, `is`(listOf()))
    }
}