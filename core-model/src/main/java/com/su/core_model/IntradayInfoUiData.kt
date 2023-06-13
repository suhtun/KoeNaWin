package com.su.core_model

import java.time.LocalDateTime

data class IntradayInfoUiData(
    val date: LocalDateTime,
    val close: Double
)