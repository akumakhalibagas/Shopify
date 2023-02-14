package com.makhalibagas.core.data.source.remote.network

import com.makhalibagas.core.BuildConfig
import com.makhalibagas.core.data.source.remote.response.ShopifyResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface ShopifyApiService {

    @GET("2023-01/products.json")
    suspend fun getProductShopify(
        @Header("X-Shopify-Access-Token") access: String = BuildConfig.API_KEY
    ): ShopifyResponse

}