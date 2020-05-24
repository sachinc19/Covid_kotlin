package com.aai.covid_kotlin.ui.login1.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aai.covid_kotlin.ui.login1.LoginViewModel1

class UserRepositoryFactory:ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
if (modelClass.isAssignableFrom(LoginViewModel1::class.java)){
    return LoginViewModel1( res = Repository()) as T
}
        throw IllegalArgumentException("Unknown ViewModel class")
    }


  /*  if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
        return LoginViewModel(
            loginRepository = LoginRepository(
                dataSource = LoginDataSource()
            )
        ) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")*/
}