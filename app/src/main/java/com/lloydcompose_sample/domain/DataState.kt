package com.lloydcompose_sample.domain

data class DataState<out T>(
    val data: T? = null,
    val error: Throwable? = null,
    val isLoading: Boolean = false
) {

    companion object {
        fun <T> success(data: T): DataState<T> = DataState(data = data)

        fun <T> loading(data: T? = null): DataState<T> =
            DataState(data = data, isLoading = true)

        fun <T> error(throwable: Throwable): DataState<T> = DataState(error = throwable)
    }
}