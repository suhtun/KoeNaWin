package com.su.core_data.repository.koenawin

import com.su.core_data.model.asEntity
import com.su.core_data.model.asUiModel
import com.su.core_localstorage.KoeNaWinDao
import com.su.core_localstorage.entity.KoeNaWinEntity
import com.su.core_model.KoeNaWinUiData
import com.su.network.KnwNetworkApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepositoryImpl @Inject constructor(
    private val api: KnwNetworkApi,
    private val koeNaWinDao: KoeNaWinDao
) : MainRepository {
    override fun getKoeNaWinStream(): Flow<List<KoeNaWinUiData>> = flow {
        var offlineData = koeNaWinDao.getAll().map(KoeNaWinEntity::asUiModel)
        if (offlineData.isEmpty()) {
            val networkData = api.getKoeNaWin()
            offlineData = networkData.map(com.su.network.model.NetworkKoeNaWin::asUiModel)
            koeNaWinDao.insertKoeNaWins(networkData.map(com.su.network.model.NetworkKoeNaWin::asEntity))
        }
        emit(offlineData)
    }.flowOn(Dispatchers.IO)

}