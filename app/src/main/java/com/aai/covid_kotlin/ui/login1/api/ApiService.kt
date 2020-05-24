package com.aai.covid_kotlin.ui.login1.api

import com.aai.covid_kotlin.constant.ApiConstant
import com.aai.covid_kotlin.ui.login1.model.LoginRequest
import com.aai.covid_kotlin.ui.login1.model.User
import com.aai.covid_kotlin.ui.login1.model.traveller.TravellerDetailDto
import com.aai.covid_kotlin.ui.login1.model.traveller.TravellerDetailsResultDto
import com.google.gson.JsonElement
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

interface ApiService{

    @GET("placeholder/user/{userId}")
    fun getUser(@Path("userId") userId:String): Call<User>

    @GET("placeholder/user/{userId}")
    fun getUser1(@Path("userId") userId:String): Observable<User>

    @POST(ApiConstant.loginVerifivcation)
    fun login(@Body data: LoginRequest):Observable<JsonElement>


    @POST(ApiConstant.getPOHistorybyid)
    fun getAllTraveller(@HeaderMap headers: Map<String, String>, @Body data :TravellerDetailsResultDto):Observable<TravellerDetailDto>

}