package com.aai.covid_kotlin.ui.login1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aai.covid_kotlin.constant.Constant
import com.aai.covid_kotlin.ui.login1.api.ApiResponse
import com.aai.covid_kotlin.ui.login1.api.Result1
import com.aai.covid_kotlin.ui.login1.api.Status
import com.aai.covid_kotlin.ui.login1.model.LoginRequest
import com.aai.covid_kotlin.ui.login1.model.User
import com.aai.covid_kotlin.ui.login1.model.traveller.TravellerDetailDto
import com.aai.covid_kotlin.ui.login1.model.traveller.TravellerDetailsResultDto
import com.aai.covid_kotlin.ui.login1.repository.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginViewModel1(private val res:Repository):ViewModel() {

    private val _loginResult = MutableLiveData<User>();
    private val loginResult: LiveData<User> = _loginResult

   // private val _loginResult1 = MutableLiveData<Result1<Employee>> =MutableLiveData();
    // private val _loginResult2 =LiveData <Result<Employee>>() =_loginResult1;

    private val _loginResult1: MutableLiveData<ApiResponse> = MutableLiveData()
    val loginResult1: LiveData<ApiResponse> = _loginResult1

    private val _travelerData = MutableLiveData<Result1<TravellerDetailDto>>();
    // private val _loginResult2 =LiveData <Result<Employee>>() =_loginResult1;

    private val compositeDisposable = CompositeDisposable();
    private val compositeDisposable1 = CompositeDisposable();

    private val data: MutableLiveData<User> = MutableLiveData()

    fun execureRespose(): LiveData<User> {

        return loginResult;
    }

    fun execureLoginRespose(): LiveData<ApiResponse> {

        return loginResult1;
    }

    fun login(loginRequst: LoginRequest) {



//call repository here
        //res.login(loginRequst)
       /* compositeDisposable.addAll(res.login(loginRequst)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                _loginResult1.value = Result.Success(result)
            },
                { throwable ->
                    _loginResult1.value = Result.Error(IOException("Error logging in", throwable))
                }
            ))*/
        compositeDisposable.add(res.login(loginRequst)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                _loginResult1.value = ApiResponse(Status.SUCCESS,result,null)
            },
                { throwable ->
                    _loginResult1.value = ApiResponse(Status.ERROR,null,throwable)
                }
            ))
    }

    fun getTraveller(map:Map<String, String>,travellerDetailsResultDto: TravellerDetailsResultDto){

    compositeDisposable.add(res.getTraveller(map,travellerDetailsResultDto)
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(
    {
        result->
        _travelerData.value = Result1.Success(result)
    },
    { throwable -> _travelerData.value = Result1.Failure(throwable) }
    ))
}

    fun getUser1(userId:String){
        compositeDisposable.add(res.getUser1(userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result -> _loginResult.value =result
                },
            {throwable-> _loginResult.value =null})
        )
    }
   /* fun login(){
        compositeDisposable.add(res.login(userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result -> _loginResult.value =result
            },
                {throwable-> _loginResult.value =null})
        )
    }*/
}



/*
private val _userId: MutableLiveData<String> = MutableLiveData()

val user: LiveData<User> = Transformations
    .switchMap(_userId){
        Repository.getUser(it)
    }

fun setUserId(userId: String){
    val update = userId
    if (_userId.value == update) {
        return
    }
    _userId.value = update
}

fun cancelJobs(){
    Repository.cancelJobs()
}*/
