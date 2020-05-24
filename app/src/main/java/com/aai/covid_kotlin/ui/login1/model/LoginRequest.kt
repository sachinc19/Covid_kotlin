package com.aai.covid_kotlin.ui.login1.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("userId")
    var username: String,
    @SerializedName("password")
    var password: String
)
