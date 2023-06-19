package com.example.githubusers.utils

sealed class Resource<out T> {
    data class Success<T>(val data: T) : Resource<T>()
    object Loading : Resource<Nothing>()
    data class Error(val viewError: ViewError) : Resource<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$viewError]"
            Loading -> "Loading"
        }
    }
}

data class ViewError(
    val message: String,
    val code: Int = -1
)