package com.makhalibagas.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ProductsItem(

	@field:SerializedName("image")
	val image: Image,

	@field:SerializedName("body_html")
	val bodyHtml: String? = null,

	@field:SerializedName("images")
	val images: List<ImagesItem?>? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("handle")
	val handle: String? = null,

	@field:SerializedName("variants")
	val variants: List<VariantsItem>,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("tags")
	val tags: String? = null,

	@field:SerializedName("published_scope")
	val publishedScope: String? = null,

	@field:SerializedName("product_type")
	val productType: String? = null,

	@field:SerializedName("template_suffix")
	val templateSuffix: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("vendor")
	val vendor: String? = null,

	@field:SerializedName("admin_graphql_api_id")
	val adminGraphqlApiId: String? = null,

	@field:SerializedName("options")
	val options: List<OptionsItem?>? = null,

	@field:SerializedName("id")
	val id: Long? = null,

	@field:SerializedName("published_at")
	val publishedAt: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)