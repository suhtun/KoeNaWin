package com.su.core_network.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.su.core_model.IntradayInfoUiData
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

data class NetworkIntradayInfo(
    val timestamp: String,
    val close: Double
)

@RequiresApi(Build.VERSION_CODES.O)
fun NetworkIntradayInfo.convert(): IntradayInfoUiData {
    val pattern = "yyyy-MM-dd HH:mm:ss"
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    val localDateTime = LocalDateTime.parse(timestamp, formatter)
    return IntradayInfoUiData(
        date = localDateTime,
        close = close
    )
}