package com.makhalibagas.shopify.utils

import com.makhalibagas.shopify.data.source.local.entity.ShopifyEntity
import com.makhalibagas.shopify.data.source.remote.response.ProductsItem
import com.makhalibagas.shopify.domain.model.ProductShopify
import com.makhalibagas.shopify.domain.model.ShopifyTransaction

object DataMapper {

    fun ProductsItem.toProductShopify() = ProductShopify(
        title.toString(),
        bodyHtml.toString(),
        variants[0].price.toString(),
        variants[0].weight.toString(),
        image.src.toString(),
        variants[0].inventoryQuantity.toString(),
        vendor.toString()
    )

    fun ShopifyEntity.toShopifyTransaction() = ShopifyTransaction(
        transactionId, title, qty, price, status, img
    )

    fun ShopifyTransaction.toShopifyEntity() = ShopifyEntity(
        transactionId, title, qty, price, status, img
    )
}