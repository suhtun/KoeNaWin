package com.su.core_data

import androidx.annotation.WorkerThread
import com.su.core_model.KoeNaWinUiData
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getKoeNaWinList(): ArrayList<KoeNaWinUiData>

    fun getKoeNaWinStream(): Flow<List<KoeNaWinUiData>>
}