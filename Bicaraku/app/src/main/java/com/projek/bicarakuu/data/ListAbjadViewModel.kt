package com.projek.bicarakuu.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListAbjadViewModel : ViewModel() {
    private val _navigateToDetail = MutableLiveData<Char?>()
    val navigateToDetail: MutableLiveData<Char?>
        get() = _navigateToDetail

    fun onItemClick(abjad: Char) {
        _navigateToDetail.value = abjad
    }

    fun onNavigationComplete() {
        _navigateToDetail.value = null
    }
}