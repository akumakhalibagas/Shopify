package com.makhalibagas.shopify.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.makhalibagas.shopify.data.source.local.entity.ShopifyEntity

@Database(
    entities = [
        ShopifyEntity::class,
    ],
    version = 31,
    exportSchema = false
)
abstract class ShopifyDatabase : RoomDatabase() {
    abstract fun shopifyDao(): ShopifyDao
}