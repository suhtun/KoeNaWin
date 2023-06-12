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
    private val _userFlow = MutableStateFlow(HomeScreenUiState(KoeNaWinUiState.Loading))
    val userFlow: StateFlow<HomeScreenUiState> = _userFlow.asStateFlow()

    init {
        viewModelScope.launch {
            repo.getKoeNaWinStream().asResult()
                .collect { result ->
                    _userFlow.update {
                        when (result) {
                            is Result.Loading -> {
                                HomeScreenUiState(KoeNaWinUiState.Loading)
                            }

                            is Result.Success -> {
                                HomeScreenUiState(KoeNaWinUiState.Success(result.data))
                            }

                            is Result.Error -> {
                                HomeScreenUiState(KoeNaWinUiState.Error)
                            }
                        }
                    }
                }
        }

    }

    fun findKoeNaWin(id: Int): KoeNaWinUiData? {
        val state = userFlow.value.koeNaWinUiState
        return if (state is KoeNaWinUiState.Success) state.koeNaWin.find { it.id ==id } else null
//        return list.find { it.id == id }
//        return null
    }

//    fun followAuthorToggle(followed: Boolean) {
//        viewModelScope.launch {
//            userDataRepository.toggleFollowedAuthorId(authorId, followed)
//        }
//    }
}

sealed interface KoeNaWinUiState {
    data class Success(val koeNaWin: List<KoeNaWinUiData>) : KoeNaWinUiState
    object Error : KoeNaWinUiState
    object Loading : KoeNaWinUiState
}

data class HomeScreenUiState(val koeNaWinUiState: KoeNaWinUiState)
