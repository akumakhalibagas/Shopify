package com.makhalibagas.core.di

import com.makhalibagas.core.data.source.remote.repository.ShopifyRepository
import com.makhalibagas.core.domain.usecase.ShopifyInsertUseCase
import com.makhalibagas.core.domain.usecase.ShopifyLocalUseCase
import com.makhalibagas.core.domain.usecase.ShopifyUseCase
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