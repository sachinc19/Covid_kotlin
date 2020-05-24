package com.aai.covid_kotlin.pojomodel


import com.google.gson.annotations.SerializedName

data class ConsumerProfile(
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("attachment")
    val attachment: String,
    @SerializedName("blocked")
    val blocked: Boolean,
    @SerializedName("consumerAddress")
    val consumerAddress: String,
    @SerializedName("consumerCountry")
    val consumerCountry: String,
    @SerializedName("consumerDistrict")
    val consumerDistrict: String,
    @SerializedName("consumerRole")
    val consumerRole: String,
    @SerializedName("consumerState")
    val consumerState: String,
    @SerializedName("createdBy")
    val createdBy: Any,
    @SerializedName("createdDate")
    val createdDate: Long,
    @SerializedName("dateOfBirth")
    val dateOfBirth: Long,
    @SerializedName("district")
    val district: Any,
    @SerializedName("emailId")
    val emailId: String,
    @SerializedName("employeeCode")
    val employeeCode: Any,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("lastUpdated")
    val lastUpdated: Long,
    @SerializedName("lastUpdatedBy")
    val lastUpdatedBy: String,
    @SerializedName("level")
    val level: Any,
    @SerializedName("loginId")
    val loginId: String,
    @SerializedName("mobileAppKey")
    val mobileAppKey: String,
    @SerializedName("mobileNo")
    val mobileNo: Long,
    @SerializedName("occupation")
    val occupation: String,
    @SerializedName("status")
    val status: String
)