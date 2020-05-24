package com.aai.covid_kotlin.ui.login1.model


import com.google.gson.annotations.SerializedName

data class Employee(
    @SerializedName("employeeCode")
    val employeeCode: String,
    @SerializedName("employeeDetails")
    val employeeDetails: EmployeeDetails,
    @SerializedName("profile")
    val profile: String,
    @SerializedName("role")
    val role: String,
    @SerializedName("token")
    val token: String
)