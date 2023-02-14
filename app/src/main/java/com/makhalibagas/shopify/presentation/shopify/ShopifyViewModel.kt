package com.makhalibagas.shopify.presentation.shopify

import androidx.lifecycle.ViewModel
import com.makhalibagas.moviesaja.state.UiStateWrapper
import com.makhalibagas.shopify.data.source.remote.Resource
import com.makhalibagas.shopify.domain.model.ProductShopify
import com.makhalibagas.shopify.domain.usecase.ShopifyUseCase
import com.makhalibagas.shopify.utils.collectLifecycleFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class ShopifyViewModel @Inject constructor(
    private val getProductShopify: ShopifyUseCase
) : ViewModel() {

    private val _productListState = MutableSharedFlow<UiStateWrapper<List<ProductShopify>>>()
    val productListState = _productListState.asSharedFlow()

    fun getShopifyProduct() {
        collectLifecycleFlow(getProductShopify()) { resource ->
            when (resource) {
                is Resource.Loading -> _productListState.emit(UiStateWrapper.Loading(true))
                is Resource.Success -> {
                    _productListState.emit(UiStateWrapper.Loading(false))
                    _productListState.emit(UiStateWrapper.Success(resource.data))
                }
                is Resource.Error -> {
                    _productListState.emit(UiStateWrapper.Loading(false))
                    _productListState.emit(UiStateWrapper.Error(resource.msg))
                }
            }
        }
    }
}