package com.makhalibagas.shopify.domain.repository

import com.makhalibagas.shopify.data.source.remote.Resource
import com.makhalibagas.shopify.domain.model.ProductShopify
import com.makhalibagas.shopify.domain.model.ShopifyTransaction
import kotlinx.coroutines.flow.Flow

interface IShopifyRepository {

    fun getProductShopify(): Flow<Resource<List<ProductShopify>>>
    fun getShopify() : Flow<List<ShopifyTransaction>>
    suspend fun insertShopify(data: ShopifyTransaction)
}