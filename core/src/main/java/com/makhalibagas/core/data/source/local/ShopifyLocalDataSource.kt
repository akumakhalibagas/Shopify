package com.makhalibagas.core.data.source.local

import com.makhalibagas.core.data.source.local.entity.ShopifyEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShopifyLocalDataSource @Inject constructor(
    private val shopifyDao: com.makhalibagas.core.data.source.local.room.ShopifyDao
) {

    fun getShopify(): Flow<List<ShopifyEntity>> =
        shopifyDao.getShopify()

    suspend fun insertShopify(data: ShopifyEntity) =
        shopifyDao.insertShopify(data)
}