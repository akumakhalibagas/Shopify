package com.makhalibagas.shopify.di

import com.makhalibagas.shopify.data.source.remote.repository.ShopifyRepository
import com.makhalibagas.shopify.domain.usecase.ShopifyInsertUseCase
import com.makhalibagas.shopify.domain.usecase.ShopifyLocalUseCase
import com.makhalibagas.shopify.domain.usecase.ShopifyUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideShopifyUseCase(repository: ShopifyRepository) =
        ShopifyUseCase(repository)

    @Provides
    @Singleton
    fun provideShopifyInsertUseCase(repository: ShopifyRepository) =
        ShopifyInsertUseCase(repository)

    @Provides
    @Singleton
    fun provideShopifyLocalUseCase(repository: ShopifyRepository) =
        ShopifyLocalUseCase(repository)

}