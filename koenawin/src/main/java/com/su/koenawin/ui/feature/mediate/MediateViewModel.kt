package com.su.koenawin.ui.feature.mediate

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MediateViewModel : ViewModel() {

    var totalCount = mutableStateOf(0)
//    val totalCount: StateFlow<MediateUiData> = _totalCount.asStateFlow()

    fun decreaseCount() {
        viewModelScope.launch {
//            val previous = _totalCount.value
//            _totalCount.emit(MediateUiData(0))
//            _totalCount.value.let {
//                if (it.totalCount >= 1)
//                    it.totalCount--
//            }
//            _totalCount.update {
//                it.copy(totalCount = 90)
//            }
            totalCount.value --

        }
    }

    fun calculateTotalCount(count: Int){
        totalCount.value = count * TIME
    }

    companion object {
        private const val TIME = 18
    }
}

data class MediateUiData(var totalCount: Int)