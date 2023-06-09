package com.su.core_data

import com.su.core_model.KoeNaWinUiData

interface MainRepository {
    fun getKoeNaWinList(): ArrayList<KoeNaWinUiData>
}