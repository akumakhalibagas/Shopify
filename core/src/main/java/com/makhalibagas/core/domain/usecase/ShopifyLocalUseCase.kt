package com.makhalibagas.core.domain.usecase

import com.makhalibagas.core.domain.model.ShopifyTransaction
import com.makhalibagas.core.domain.repository.IShopifyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShopifyLocalUseCase @Inject constructor(
    private val repository: IShopifyRepository
) {

    operator fun invoke(): Flow<List<ShopifyTransaction>> = repository.getShopify()
}