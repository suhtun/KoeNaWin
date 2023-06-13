package com.su.feature_companyinfo

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.su.core_data.repository.stockmarket.StockMarketMainRepository
import com.su.core_model.CompanyInfoUiData
import com.su.core_model.IntradayInfoUiData
import com.su.feature_companyinfo.navigation.CompanyInfoDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyInfoViewModel @Inject constructor(
    repo: StockMarketMainRepository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val symbol: String = checkNotNull(savedStateHandle[CompanyInfoDestination.symbolArgs])

    private val _companyInfo = MutableStateFlow(CompanyInfoUiState())
    var uiState: StateFlow<CompanyInfoUiState> = _companyInfo.asStateFlow()
    init {
        viewModelScope.launch {
            uiState = combine(repo.getCompanyInfo(symbol = symbol),repo.getIntradayInfo(symbol = symbol)){company, intradayInfo ->
               CompanyInfoUiState(company = company, stockInfos = intradayInfo, isLoading = false)
            }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = CompanyInfoUiState(isLoading = true)
        )

        }
    }
}

data class CompanyInfoUiState(
    val stockInfos: List<IntradayInfoUiData> = emptyList(),
    val company: CompanyInfoUiData? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)