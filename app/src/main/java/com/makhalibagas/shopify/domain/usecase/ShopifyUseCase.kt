package com.makhalibagas.shopify.domain.usecase

import com.makhalibagas.shopify.data.source.remote.Resource
import com.makhalibagas.shopify.domain.model.ProductShopify
import com.makhalibagas.shopify.domain.repository.IShopifyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShopifyUseCase @Inject constructor(
    private val repository: IShopifyRepository
) {

    operator fun invoke(): Flow<Resource<List<ProductShopify>>> = repository.getProductShopify()
}