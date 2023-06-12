package com.su.core_data

import com.su.core_data.model.asEntity
import com.su.core_data.model.asUiModel
import com.su.core_localstorage.KoeNaWinDao
import com.su.core_localstorage.entity.KoeNaWinEntity
import com.su.core_model.KoeNaWinUiData
import com.su.core_network.model.NetworkKoeNaWin
import com.su.core_network.model.convert
import com.su.core_network.retrofit.RetrofitKNWNetworkApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepositoryImpl @Inject constructor(
    private val network: RetrofitKNWNetworkApi,
    private val koeNaWinDao: KoeNaWinDao
) : MainRepository {
    override fun getKoeNaWinList(): ArrayList<KoeNaWinUiData> {
        var mockData = ArrayList<KoeNaWinUiData>()
        return mockData
    }

    override fun getKoeNaWinStream(): Flow<List<KoeNaWinUiData>> = flow {
        var offlineData = koeNaWinDao.getAll().map(KoeNaWinEntity::asUiModel)
        if (offlineData.isEmpty()) {
            val networkData = network.getKoeNaWin()
            offlineData = networkData.map(NetworkKoeNaWin::asUiModel)
            koeNaWinDao.insertKoeNaWins(networkData.map(NetworkKoeNaWin::asEntity))
        }
        emit(offlineData)
    }.flowOn(Dispatchers.IO)

}