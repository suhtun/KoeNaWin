package com.su.core_network.model

import com.squareup.moshi.Json
import com.su.core_model.KoeNaWinUiData

data class NetworkKoeNaWin(@Json val id:String,
                           @Json val day: String,
                           @Json val gonedaw:String,
                           @Json val gonedawTranslate:String,
                           @Json val showCount:String,
                           @Json val count:Int)

fun NetworkKoeNaWin.convert() = KoeNaWinUiData(this.id,this.day,this.gonedaw,this.gonedawTranslate,this.showCount,this.count)
