package com.example.foodcompose.utils

sealed class ResultOf<out T> {
    data class Success<out R>(val value: R): ResultOf<R>()
    data class Cache<out R>(val value: R): ResultOf<R>()
    data class Failure(
        val message: String? = null,
        val code: Int? = null,
        val throwable: Throwable? = null
    ): ResultOf<Nothing>()
}
