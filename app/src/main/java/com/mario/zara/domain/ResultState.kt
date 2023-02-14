package com.mario.zara.domain

sealed interface ResultState<T>

sealed class Result<T> : ResultState<T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error<T>(val message: CharSequence) : Result<T>()
}
