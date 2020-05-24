package com.aai.covid_kotlin.pojomodel


import com.google.gson.annotations.SerializedName

data class UserProfileMain(
    @SerializedName("consumerProfile")
    val consumerProfile: ConsumerProfile,
    @SerializedName("districtList")
    val districtList: List<Any>,
    @SerializedName("menuList")
    val menuList: List<Menu>,
    @SerializedName("roleObj")
    val roleObj: String,
    @SerializedName("token")
    val token: String
)