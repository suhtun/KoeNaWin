package com.su.koenawin.ui.feature.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.su.core_data.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: MainRepository): ViewModel() {
    private val _koeNaWinList = mutableStateOf(repo.getKoeNaWinList())
    val koeNaWinList = _koeNaWinList

}
