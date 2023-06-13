package com.su.koenawin.ui.feature.mediate

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MediateViewModel : ViewModel() {

    private val _totalCount = MutableStateFlow(MediateUiData(0))
    val totalCount: StateFlow<MediateUiData> = _totalCount.asStateFlow()

    fun decreaseCount() {
        Log.d("main","drcreas")
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

            _totalCount.value = _totalCount.value.copy(totalCount = 90)

        }
    }

    fun calculateTotalCount(count: Int) {
        viewModelScope.launch {
            _totalCount.value.apply {
                this.totalCount = count * TIME
            }
        }

    }

    companion object {
        private const val TIME = 18
    }
}

data class MediateUiData(var totalCount: Int)