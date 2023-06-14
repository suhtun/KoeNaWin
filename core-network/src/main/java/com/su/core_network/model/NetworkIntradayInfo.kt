package com.su.core_network.model

import com.su.core_model.IntradayInfoUiData
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

data class NetworkIntradayInfoBeforeParser(
    var timestamp: String,
    var close: Double
)

data class NetworkIntradayInfo(
    var date: LocalDateTime,
    var close: Double
)



fun NetworkIntradayInfoBeforeParser.convert(): NetworkIntradayInfo {
    val pattern = "yyyy-MM-dd HH:mm:ss"
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    val localDateTime = LocalDateTime.parse(timestamp, formatter)
    return NetworkIntradayInfo(
        date = localDateTime,
        close = close
    )
}

fun IntradayInfoUiData.asNetwork() = NetworkIntradayInfo(
    date = date,
    close = close
)

fun NetworkIntradayInfo.asUiModel() = IntradayInfoUiData(
    date = date,
    close = close
)
