package com.su.core_data.model

import com.su.core_model.CompanyInfoUiData
import com.su.core_network.model.NetworkCompanyInfo

fun NetworkCompanyInfo.asUiModel()=CompanyInfoUiData(
    symbol = symbol ?: "", description = description ?: "",
    name = name ?: "", country = country ?: "", industry = industry ?: ""
)
