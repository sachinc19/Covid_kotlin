package com.aai.covid_kotlin.ui.login1.repository

import android.util.Log
import com.aai.covid_kotlin.ui.login1.api.MyRetrofitBuilder
import com.aai.covid_kotlin.ui.login1.model.LoginRequest
import com.aai.covid_kotlin.ui.login1.model.User
import com.aai.covid_kotlin.ui.login1.model.traveller.TravellerDetailDto
import com.aai.covid_kotlin.ui.login1.model.traveller.TravellerDetailsResultDto
import com.google.gson.Gson
import com.google.gson.JsonElement
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(/*val apiService: ApiService*/){

    fun getUser1( userid:String): Observable<User> {

        return MyRetrofitBuilder.apiService.getUser1(userid);
    }

    fun login(data: LoginRequest):Observable<JsonElement>{
        return MyRetrofitBuilder.apiService.login(data)
    }
    fun getTraveller(map:Map<String, String>,travellerDetailsResultDto: TravellerDetailsResultDto):Observable<TravellerDetailDto>{
        return MyRetrofitBuilder.apiService.getAllTraveller(map,travellerDetailsResultDto)
    }
    fun login(userId:String){

        //make  Retrofit call
        MyRetrofitBuilder.apiService.getUser(userId).enqueue(object :Callback<User>{
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("Error:","Error: ")
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
              Log.d("Response: ","response: ${Gson().toJson(response.body())}")
            }
        } );
    }
}


/*
object Repository{
  //  var job :CompletableJob?=null

    */
/*fun getUser(userId:String):LiveData<User>{
        job = Job()
        return object: LiveData<User>(){
            override fun onActive() {
                super.onActive()
                job?.let{  thejob ->
                    CoroutineScope(IO+ thejob).launch {
                        val user = MyRetrofitBuilder.apiService.getUser(userId)
                        withContext(Main){
                            value=user.execute().body();
                            thejob?.complete()
                        }
                    }
                }

            }
        }
    }*//*

    fun getUser(userId: String): LiveData<User> {
    }



}*/
