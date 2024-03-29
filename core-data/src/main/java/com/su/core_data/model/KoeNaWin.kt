package com.su.core_data.model

import com.su.core_localstorage.entity.KoeNaWinEntity
import com.su.core_model.KoeNaWinUiData
import com.su.network.model.NetworkKoeNaWin

fun com.su.network.model.NetworkKoeNaWin.asEntity() = KoeNaWinEntity(
    id = id,
    dayString = day,
    gontaw = gonedaw,
    gontawTranslation = gonedawTranslate,
    showCount = showCount,
    count = count
)

fun KoeNaWinEntity.asUiModel() = KoeNaWinUiData(
    id = id,
    dayString = dayString ?: "",
    gontaw = nullStringWrapper(gontaw),
    gontawTranslation = nullStringWrapper(gontawTranslation),
    showCount = nullStringWrapper(showCount),
    count = count
)

fun com.su.network.model.NetworkKoeNaWin.asUiModel() = KoeNaWinUiData(
    id = id,
    dayString = day ?: "",
    gontaw = nullStringWrapper(gonedaw),
    gontawTranslation = nullStringWrapper(gonedawTranslate),
    showCount = nullStringWrapper(showCount),
    count = count
)

fun nullStringWrapper(string: String?): String = string ?: ""