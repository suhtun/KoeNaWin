package com.su.core_data.mock

import com.su.core_localstorage.stockmarket.CompanyListingEntity
import com.su.core_localstorage.stockmarket.StockDao
import com.su.core_localstorage.stockmarket.asEntity
import com.su.core_model.CompanyListUiData
import com.su.core_test.MockUtil
import kotlinx.coroutines.flow.MutableStateFlow

class TestStockDao : StockDao {
    private var entitiesStateFlow = MutableStateFlow(
        listOf(MockUtil.mockCompayListing().let(CompanyListUiData::asEntity))
    )

    override suspend fun insertCompanyListings(companyListingEntities: List<CompanyListingEntity>) {
        entitiesStateFlow.value = companyListingEntities
    }

    override suspend fun clearCompanyListings() {
        entitiesStateFlow.value = emptyList()
    }

    override suspend fun searchCompanyListing(query: String): List<CompanyListingEntity> {
        return entitiesStateFlow.value.filter { it.symbol ==query }
    }

    override suspend fun getAllCompanyList(): List<CompanyListingEntity> {
        return entitiesStateFlow.value
    }
}