package com.su.feature_companylisting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.su.core_commom.Result
import com.su.core_commom.asResult
import com.su.core_data.repository.stockmarket.StockMarketMainRepository
import com.su.core_model.CompanyListUiData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyListingViewModel @Inject constructor(repo: StockMarketMainRepository): ViewModel() {
    private val _companys = MutableStateFlow(StockMarketScreenUiState(StockMarketState.Loading))
    val uiState: StateFlow<StockMarketScreenUiState> = _companys.asStateFlow()

    init {
        viewModelScope.launch {
            repo.getCompanyList("").asResult().collect{ result ->
                _companys.update {
                    when(result){
                        is Result.Loading -> {
                            StockMarketScreenUiState(StockMarketState.Loading)
                        }

                        is Result.Success -> {
                            StockMarketScreenUiState(StockMarketState.Success(result.data))
                        }

                        is Result.Error -> {
                            StockMarketScreenUiState(StockMarketState.Default)
                        }
                    }
                }
            }

        }
    }
}


sealed interface StockMarketState {

    object Loading : StockMarketState

    data class Success(
        val companies: List<CompanyListUiData>
    ) : StockMarketState

    object Default : StockMarketState
}

data class StockMarketScreenUiState(val stockMarketState: StockMarketState)