package com.su.core_test

import android.os.Build
import androidx.annotation.RequiresApi
import com.su.core_model.CompanyInfoUiData
import com.su.core_model.CompanyListUiData
import com.su.core_model.IntradayInfoUiData
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

object MockUtil {

    fun mockCompanyListings() = listOf(mockCompayListing())

    fun mockCompayListing() = CompanyListUiData(name = "Agilent Technologies Inc", "AA", "NYSE ARCA")

    fun mockIntradayInfo() = IntradayInfoUiData(LocalDateTime.parse("1970-01-01 00:00:01",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.getDefault())),2.2)

    fun mockIntradayInfos() = listOf(mockIntradayInfo())

    fun mockCompanyInfoUiData() = CompanyInfoUiData("AA","Agilent Technologies Inc","Agilent Technologies Inc","Singapore","Stock")
}