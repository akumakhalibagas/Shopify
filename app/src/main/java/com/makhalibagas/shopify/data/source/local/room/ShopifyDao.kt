package com.makhalibagas.shopify.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.makhalibagas.shopify.data.source.local.entity.ShopifyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShopifyDao {

    @Query("SELECT * FROM shopify_transaction")
    fun getShopify(): Flow<List<ShopifyEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShopify(data: ShopifyEntity)
}