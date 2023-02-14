package com.makhalibagas.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductShopify(
	val title: String,
	val desc: String,
	val price: String,
	val weight: String,
	val images: String,
	val stock: String,
	val seller: String
) : Parcelable