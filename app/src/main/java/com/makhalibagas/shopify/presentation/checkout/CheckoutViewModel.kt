package com.makhalibagas.shopify.presentation.checkout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.makhalibagas.shopify.domain.model.ShopifyTransaction
import com.makhalibagas.shopify.domain.usecase.ShopifyInsertUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckoutViewModel @Inject constructor(
    private val insertUseCase: ShopifyInsertUseCase
) : ViewModel() {

    fun insertShopify(data: ShopifyTransaction) {
        viewModelScope.launch {
            insertUseCase.invoke(data)
        }
    }

}