package com.aai.covid_kotlin.ui.login1.model


import com.google.gson.annotations.SerializedName

data class EmployeeDetails(
    @SerializedName("attemptsCount")
    val attemptsCount: Int,
    @SerializedName("createdTime")
    val createdTime: Any,
    @SerializedName("dob")
    val dob: Any,
    @SerializedName("emailId")
    val emailId: String,
    @SerializedName("employeeCode")
    val employeeCode: Int,
    @SerializedName("expiryDate")
    val expiryDate: Any,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("identificationKey")
    val identificationKey: String,
    @SerializedName("isExpire")
    val isExpire: Boolean,
    @SerializedName("isFirstattempt")
    val isFirstattempt: Boolean,
    @SerializedName("isLocked")
    val isLocked: Boolean,
    @SerializedName("lastLoggedinDatetime")
    val lastLoggedinDatetime: Any,
    @SerializedName("lastPasswordResetDate")
    val lastPasswordResetDate: Any,
    @SerializedName("loginId")
    val loginId: String,
    @SerializedName("mobileNo")
    val mobileNo: Int,
    @SerializedName("password")
    val password: String,
    @SerializedName("profileName")
    val profileName: String,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("userRole")
    val userRole: String
)