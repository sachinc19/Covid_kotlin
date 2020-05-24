package com.aai.covid_kotlin.ui.login1.api

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import com.google.gson.JsonElement
import java.util.*


class ApiResponse1  constructor(status: Status, @Nullable data: Objects?, @Nullable error: Throwable?) {
    val status: Status
    @Nullable
    val data: Objects?
    @Nullable
    val error: Throwable?

    companion object {
        fun loading(): ApiResponse1 {
            return ApiResponse1(Status.LOADING, null, null)
        }

        fun success(@NonNull data: Objects?): ApiResponse1 {
            return ApiResponse1(Status.SUCCESS, data, null)
        }

        fun error(@NonNull error: Throwable?): ApiResponse1 {
            return ApiResponse1(Status.ERROR, null, error)
        }
    }

    init {
        this.status = status
        this.data = data
        this.error = error
    }
}