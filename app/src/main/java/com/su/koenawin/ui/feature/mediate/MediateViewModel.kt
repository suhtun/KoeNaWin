package com.su.koenawin.ui.feature.mediate

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.su.core_data.MainRepository
import com.su.core_model.KoeNaWinUiData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MediateViewModel @Inject constructor(private val repo: MainRepository): ViewModel() {
    private val _totalCount = mutableStateOf(0)

    fun decreaseCount() {
        val totalCount = _totalCount.value
        if (totalCount >= 1) _totalCount.value--
    }

    fun calculateTotalCount(count:Int){
        _totalCount.value =  count*18
    }

    fun showCurrentValue(): String {
        val totalCount = _totalCount.value
        return if (totalCount <= 0) "DONE" else "$totalCount"
    }
}