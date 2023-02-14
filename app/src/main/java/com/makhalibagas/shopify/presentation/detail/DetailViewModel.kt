package com.makhalibagas.shopify.presentation.detail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel : ViewModel() {

    private val _qty = MutableStateFlow(1)
    val qty = _qty.asStateFlow()

    fun plusQty() {
        _qty.value = qty.value + 1
    }

    fun minusQty() {
        _qty.value = qty.value - 1
    }
}