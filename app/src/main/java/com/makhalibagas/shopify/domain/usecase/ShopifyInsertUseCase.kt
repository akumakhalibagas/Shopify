package com.makhalibagas.shopify.domain.usecase

import com.makhalibagas.shopify.domain.model.ShopifyTransaction
import com.makhalibagas.shopify.domain.repository.IShopifyRepository
import javax.inject.Inject

class ShopifyInsertUseCase @Inject constructor(
    private val repository: IShopifyRepository
) {

    suspend operator fun invoke(data: ShopifyTransaction) = repository.insertShopify(data)
}