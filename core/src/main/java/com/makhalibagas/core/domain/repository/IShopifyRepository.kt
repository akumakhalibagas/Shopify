package com.makhalibagas.core.domain.repository

import com.makhalibagas.core.domain.model.ProductShopify
import com.makhalibagas.core.domain.model.ShopifyTransaction
import kotlinx.coroutines.flow.Flow

interface IShopifyRepository {

    fun getProductShopify(): Flow<com.makhalibagas.core.data.source.remote.Resource<List<ProductShopify>>>
    fun getShopify(): Flow<List<ShopifyTransaction>>
    suspend fun insertShopify(data: ShopifyTransaction)
}