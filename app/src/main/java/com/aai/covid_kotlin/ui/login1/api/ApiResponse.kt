package com.aai.covid_kotlin.ui.login1.api

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import com.google.gson.JsonElement


class ApiResponse  constructor(status: Status, @Nullable data: JsonElement?, @Nullable error: Throwable?) {
    val status: Status
    @Nullable
    val data: JsonElement?
    @Nullable
    val error: Throwable?

    companion object {
        fun loading(): ApiResponse {
            return ApiResponse(Status.LOADING, null, null)
        }

        fun success(@NonNull data: JsonElement?): ApiResponse {
            return ApiResponse(Status.SUCCESS, data, null)
        }

        fun error(@NonNull error: Throwable?): ApiResponse {
            return ApiResponse(Status.ERROR, null, error)
        }
    }

    init {
        this.status = status
        this.data = data
        this.error = error
    }
}