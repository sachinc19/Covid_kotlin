package com.aai.covid_kotlin.ui.login1.api

import com.aai.covid_kotlin.constant.ApiConstant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofitBuilder {
       val okHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(
            Interceptor { chain ->
                val builder = chain.request().newBuilder()
                builder.header("Content-Type", "application/json")
                builder.header("X-Platform", "Android")
                builder.header("X-Auth-Token", "sgsrager32524542afg3423")
                return@Interceptor chain.proceed(builder.build())
            }
        )
    }.build()

    val RetrofitBuilder:Retrofit.Builder by lazy { Retrofit.Builder()
        .baseUrl(ApiConstant.ipAddress)
       // .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    val apiService: ApiService  by lazy { RetrofitBuilder

        .build()
        .create(ApiService::class.java)
    }
}

/*
class Singleton private constructor() {

    private object HOLDER {
        val INSTANCE = Singleton()
    }

    companion object {
        val instance: Singleton by lazy { HOLDER.INSTANCE }
    }
}*/
