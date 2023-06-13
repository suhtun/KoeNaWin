package com.su.core_data.repository.koenawin

import androidx.annotation.WorkerThread
import com.su.core_model.KoeNaWinUiData
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getKoeNaWinStream(): Flow<List<KoeNaWinUiData>>
}