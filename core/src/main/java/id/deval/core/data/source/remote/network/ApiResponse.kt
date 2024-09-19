package id.deval.core.data.source.remote.network

sealed class ApiResponse <out R>{
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error<T>(val errorMessage: String) : ApiResponse<T>()
    object Empty : ApiResponse<Nothing>()
}