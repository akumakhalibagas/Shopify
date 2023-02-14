package com.makhalibagas.shopify.domain.model


data class ShopifyTransaction(

    var transactionId: Long = 0,
    var title: String,
    var qty: String,
    var price: String,
    var status: String,
    var img: String,
    )