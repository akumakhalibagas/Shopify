package com.makhalibagas.core.data.source.remote

import android.content.Context
import com.makhalibagas.core.R
import com.makhalibagas.core.data.source.remote.network.ApiResponse
import com.makhalibagas.core.data.source.remote.network.ShopifyApiService
import com.makhalibagas.core.data.source.remote.response.ProductsItem
import com.makhalibagas.core.utils.isNetworkAvailable
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShopifyRemoteDataSource @Inject constructor(
    @ApplicationContext val context: Context,
    private val apiService: ShopifyApiService
){

    fun getProductShopify(): Flow<ApiResponse<List<ProductsItem>>> =
        flow {
            if (!context.isNetworkAvailable()) {
                emit(ApiResponse.Error(context.getString(R.string.text_error_network_not_avail)))
                return@flow
            }

            try {
                val response = apiService.getProductShopify()
                if (response.products != null) {
                    emit(ApiResponse.Success(response.products))
                    return@flow
                }
                emit(ApiResponse.Error("Ops there problem"))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
}