package com.makhalibagas.shopify.data.source.local

import com.makhalibagas.shopify.data.source.local.entity.ShopifyEntity
import com.makhalibagas.shopify.data.source.local.room.ShopifyDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShopifyLocalDataSource @Inject constructor(
    private val shopifyDao: ShopifyDao
) {

    fun getShopify() : Flow<List<ShopifyEntity>> = shopifyDao.getShopify()
    suspend fun insertShopify(data: ShopifyEntity) = shopifyDao.insertShopify(data)
}