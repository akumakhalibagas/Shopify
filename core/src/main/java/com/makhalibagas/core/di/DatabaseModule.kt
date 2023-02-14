package com.makhalibagas.core.di

import android.content.Context
import androidx.room.Room
import com.makhalibagas.core.data.source.local.room.ShopifyDao
import com.makhalibagas.core.data.source.local.room.ShopifyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): com.makhalibagas.core.data.source.local.room.ShopifyDatabase {
        val databaseName = "Shopify.db"

        return Room.databaseBuilder(context, com.makhalibagas.core.data.source.local.room.ShopifyDatabase::class.java, databaseName)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideShopifyDao(database: com.makhalibagas.core.data.source.local.room.ShopifyDatabase): com.makhalibagas.core.data.source.local.room.ShopifyDao =
        database.shopifyDao()
}