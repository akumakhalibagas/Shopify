package com.makhalibagas.moviesaja.state

sealed class UiStateWrapper<out T> {
    data class Success<out T>(val data: T) : UiStateWrapper<T>()
    data class Loading(val isLoading: Boolean) : UiStateWrapper<Nothing>()
    data class Error(val msg: String) : UiStateWrapper<Nothing>()
}