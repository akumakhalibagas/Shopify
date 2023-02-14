package com.makhalibagas.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopify_transaction")
data class ShopifyEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "transactionId")
    var transactionId: Long = 0,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "qty")
    var qty: String,

    @ColumnInfo(name = "price")
    var price: String,

    @ColumnInfo(name = "status")
    var status: String,

    @ColumnInfo(name = "img")
    var img: String,

    )