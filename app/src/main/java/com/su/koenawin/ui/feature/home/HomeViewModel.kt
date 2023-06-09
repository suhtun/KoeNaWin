package com.su.koenawin.ui.feature.home

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.su.core_commom.Result
import com.su.core_commom.asResult
import com.su.core_data.MainRepository
import com.su.core_model.KoeNaWinUiData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: MainRepository) : ViewModel() {
    private val _koeNaWinList = mutableStateOf(repo.getKoeNaWinList())
    val koeNaWinList = _koeNaWinList

    private val _userFlow = MutableStateFlow(HomeScreenUiState(KoeNaWinUiState.Loading))
    val userFlow: StateFlow<HomeScreenUiState> = _userFlow.asStateFlow()

    init {
        viewModelScope.launch {
            repo.getKoeNaWinStream().asResult()
                .collect { result ->
                    _userFlow.update {
                        when (result) {
                            is Result.Loading -> {
                                Log.d("home","loading")
                                HomeScreenUiState(KoeNaWinUiState.Loading)
                            }
                            is Result.Success -> {
                                Log.d("home","safddsf ${result.data}")
                                HomeScreenUiState(KoeNaWinUiState.Success(result.data))
                            }
                            is Result.Error ->{
                                Log.d("home","error ${result.exception}")
                                HomeScreenUiState(KoeNaWinUiState.Error)
                            }
                        }
                    }
                }
        }

    }
}

sealed interface KoeNaWinUiState {
    data class Success(val koeNaWin: List<KoeNaWinUiData>) : KoeNaWinUiState
    object Error : KoeNaWinUiState
    object Loading : KoeNaWinUiState
}

data class HomeScreenUiState(val koeNaWinUiState: KoeNaWinUiState)
