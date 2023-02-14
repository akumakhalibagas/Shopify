package com.makhalibagas.shopify.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class VariantsItem(

	@field:SerializedName("inventory_management")
	val inventoryManagement: String? = null,

	@field:SerializedName("old_inventory_quantity")
	val oldInventoryQuantity: Int? = null,

	@field:SerializedName("requires_shipping")
	val requiresShipping: Boolean? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("inventory_item_id")
	val inventoryItemId: Long? = null,

	@field:SerializedName("price")
	val price: String? = null,

	@field:SerializedName("product_id")
	val productId: Long? = null,

	@field:SerializedName("option3")
	val option3: Any? = null,

	@field:SerializedName("option1")
	val option1: String? = null,

	@field:SerializedName("id")
	val id: Long? = null,

	@field:SerializedName("option2")
	val option2: Any? = null,

	@field:SerializedName("sku")
	val sku: String? = null,

	@field:SerializedName("grams")
	val grams: Int? = null,

	@field:SerializedName("barcode")
	val barcode: String? = null,

	@field:SerializedName("inventory_quantity")
	val inventoryQuantity: Int? = null,

	@field:SerializedName("compare_at_price")
	val compareAtPrice: Any? = null,

	@field:SerializedName("fulfillment_service")
	val fulfillmentService: String? = null,

	@field:SerializedName("taxable")
	val taxable: Boolean? = null,

	@field:SerializedName("weight")
	val weight: Int? = null,

	@field:SerializedName("inventory_policy")
	val inventoryPolicy: String? = null,

	@field:SerializedName("weight_unit")
	val weightUnit: String? = null,

	@field:SerializedName("admin_graphql_api_id")
	val adminGraphqlApiId: String? = null,

	@field:SerializedName("position")
	val position: Int? = null,

	@field:SerializedName("image_id")
	val imageId: Any? = null
)