package com.makhalibagas.shopify.presentation.transaction

import androidx.lifecycle.ViewModel
import com.makhalibagas.core.domain.model.ShopifyTransaction
import com.makhalibagas.core.domain.usecase.ShopifyLocalUseCase
import com.makhalibagas.core.utils.collectLifecycleFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val getTransaction: ShopifyLocalUseCase
) : ViewModel() {

    private val _productListState = MutableSharedFlow<List<ShopifyTransaction>>()
    val productListState = _productListState.asSharedFlow()

    fun getShopifyProduct() {
        collectLifecycleFlow(getTransaction()) { resource ->
            _productListState.emit(resource)
        }
    }

}