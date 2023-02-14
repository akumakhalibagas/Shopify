package com.makhalibagas.core.domain.usecase

import com.makhalibagas.core.domain.model.ProductShopify
import com.makhalibagas.core.domain.repository.IShopifyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShopifyUseCase @Inject constructor(
    private val repository: IShopifyRepository
) {

    operator fun invoke(): Flow<com.makhalibagas.core.data.source.remote.Resource<List<ProductShopify>>> =
        repository.getProductShopify()
}