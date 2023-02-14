package com.makhalibagas.core.data.source.remote

sealed class Resource<out R> {
    object Loading : Resource<Nothing>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val msg: String) : Resource<Nothing>()
}