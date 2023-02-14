package com.makhalibagas.core.data.source.remote.repository

import com.makhalibagas.core.data.source.remote.network.ApiResponse
import com.makhalibagas.core.domain.model.ProductShopify
import com.makhalibagas.core.domain.model.ShopifyTransaction
import com.makhalibagas.core.domain.repository.IShopifyRepository
import com.makhalibagas.core.utils.DataMapper.toProductShopify
import com.makhalibagas.core.utils.DataMapper.toShopifyEntity
import com.makhalibagas.core.utils.DataMapper.toShopifyTransaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShopifyRepository @Inject constructor(
    private val remoteDataSource: com.makhalibagas.core.data.source.remote.ShopifyRemoteDataSource,
    private val localDataSource: com.makhalibagas.core.data.source.local.ShopifyLocalDataSource
) : IShopifyRepository {

    override fun getProductShopify(): Flow<com.makhalibagas.core.data.source.remote.Resource<List<ProductShopify>>> =
        flow {
            emit(com.makhalibagas.core.data.source.remote.Resource.Loading)
            when (val apiResource = remoteDataSource.getProductShopify().first()) {
                is ApiResponse.Success -> {
                    emit(com.makhalibagas.core.data.source.remote.Resource.Success(apiResource.data.map { it.toProductShopify() }))
                }
                is ApiResponse.Error -> {
                    emit(com.makhalibagas.core.data.source.remote.Resource.Error(apiResource.msg))
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