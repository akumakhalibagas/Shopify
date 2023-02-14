package com.makhalibagas.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class OptionsItem(

	@field:SerializedName("product_id")
	val productId: Long? = null,

	@field:SerializedName("values")
	val values: List<String?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Long? = null,

	@field:SerializedName("position")
	val position: Int? = null
)