package com.makhalibagas.shopify.domain.usecase

import com.makhalibagas.shopify.domain.model.ShopifyTransaction
import com.makhalibagas.shopify.domain.repository.IShopifyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShopifyLocalUseCase @Inject constructor(
    private val repository: IShopifyRepository
) {

    operator fun invoke(): Flow<List<ShopifyTransaction>> = repository.getShopify()
}