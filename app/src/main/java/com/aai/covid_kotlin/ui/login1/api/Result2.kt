package com.aai.covid_kotlin.ui.login1.api

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result2<T> {
    class Loading<T> : Result2<T>()
    data class Success<T>(val data: T) : Result2<T>()
    data class Failure<T>(val message: Throwable) : Result2<T>()
    data class Status<String>(val message: String) : Result2<String>()

    companion object {
        fun <T> loading(): Result2<T> = Loading()
        fun <T> success(data: T): Result2<T> = Success(data)
        fun <T> failure(message: Throwable): Result2<T> = Failure(message)
    }
}
/*sealed class Result1<out T : Any> {

    data class Success<out T : Any>(val data: T,val status:String) : Result1<T>()
    data class Error(val exception: Exception,val status:String) : Result1<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}*/
