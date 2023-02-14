package com.makhalibagas.shopify.data.source.remote.network

sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val msg: String) : ApiResponse<Nothing>()
}