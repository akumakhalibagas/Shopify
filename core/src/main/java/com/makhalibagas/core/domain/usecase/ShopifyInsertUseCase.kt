package com.makhalibagas.core.domain.usecase

import com.makhalibagas.core.domain.model.ShopifyTransaction
import com.makhalibagas.core.domain.repository.IShopifyRepository
import javax.inject.Inject

class ShopifyInsertUseCase @Inject constructor(
    private val repository: IShopifyRepository
) {

    suspend operator fun invoke(data: ShopifyTransaction) = repository.insertShopify(data)
}