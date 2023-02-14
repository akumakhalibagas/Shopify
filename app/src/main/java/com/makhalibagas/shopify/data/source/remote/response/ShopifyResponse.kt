package com.makhalibagas.shopify.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ShopifyResponse(

	@field:SerializedName("products")
	val products: List<ProductsItem>? = null
)