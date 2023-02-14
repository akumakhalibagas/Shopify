package com.makhalibagas.shopify.di

import android.content.Context
import androidx.room.Room
import com.makhalibagas.shopify.data.source.local.room.ShopifyDao
import com.makhalibagas.shopify.data.source.local.room.ShopifyDatabase
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
    fun provideDatabase(@ApplicationContext context: Context): ShopifyDatabase {
        val databaseName = "Shopify.db"

        return Room.databaseBuilder(context, ShopifyDatabase::class.java, databaseName)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideShopifyDao(database: ShopifyDatabase): ShopifyDao =
        database.shopifyDao()
}