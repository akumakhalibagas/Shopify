package com.makhalibagas.shopify.data.source.remote.repository

import com.makhalibagas.shopify.data.source.local.ShopifyLocalDataSource
import com.makhalibagas.shopify.data.source.remote.Resource
import com.makhalibagas.shopify.data.source.remote.ShopifyRemoteDataSource
import com.makhalibagas.shopify.data.source.remote.network.ApiResponse
import com.makhalibagas.shopify.domain.model.ProductShopify
import com.makhalibagas.shopify.domain.model.ShopifyTransaction
import com.makhalibagas.shopify.domain.repository.IShopifyRepository
import com.makhalibagas.shopify.utils.DataMapper.toProductShopify
import com.makhalibagas.shopify.utils.DataMapper.toShopifyEntity
import com.makhalibagas.shopify.utils.DataMapper.toShopifyTransaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShopifyRepository @Inject constructor(
    private val remoteDataSource: ShopifyRemoteDataSource,
    private val localDataSource: ShopifyLocalDataSource
) : IShopifyRepository {

    override fun getProductShopify(): Flow<Resource<List<ProductShopify>>> = flow {
        emit(Resource.Loading)
        when (val apiResource = remoteDataSource.getProductShopify().first()) {
            is ApiResponse.Success -> {
                emit(Resource.Success(apiResource.data.map { it.toProductShopify() }))
            }
            is ApiResponse.Error -> {
                emit(Resource.Error(apiResource.msg))
            }
        }
    }

    override fun getShopify(): Flow<List<ShopifyTransaction>> = flow {
        val localResource = localDataSource.getShopify().first()
        emit(localResource.map { it.toShopifyTransaction() })
    }

    override suspend fun insertShopify(data: ShopifyTransaction) {
        val dataTransaction = data.toShopifyEntity()
        localDataSource.insertShopify(dataTransaction)
    }


}