package com.aai.covid_kotlin.ui.login1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aai.covid_kotlin.R
import com.aai.covid_kotlin.constant.Constant
import com.aai.covid_kotlin.database.DatabaseHelper
import com.aai.covid_kotlin.pojomodel.UserProfileMain
import com.aai.covid_kotlin.ui.dashboard.MainActivity
import com.aai.covid_kotlin.ui.login1.api.Status
import com.aai.covid_kotlin.ui.login1.model.Employee
import com.aai.covid_kotlin.ui.login1.model.LoginRequest
import com.aai.covid_kotlin.ui.login1.model.traveller.TravellerDetailsResultDto
import com.aai.covid_kotlin.ui.login1.repository.UserRepositoryFactory
import com.aai.covid_kotlin.utility.PreferenceHelper.defaultPrefs
import com.aai.covid_kotlin.utility.PreferenceHelper.get
import com.aai.covid_kotlin.utility.PreferenceHelper.set
import com.aai.covid_kotlin.utility.Utility.hideOverlay
import com.aai.covid_kotlin.utility.Utility.md5
import com.aai.covid_kotlin.utility.Utility.showOverlay
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login1.*


class LoginActivity1 : AppCompatActivity(), View.OnClickListener {
    lateinit var travellerDetailsResultDto: TravellerDetailsResultDto
    lateinit var loginrequest: LoginRequest
    lateinit var LoginViewModel: LoginViewModel1
    lateinit var empdetails: UserProfileMain;
    private lateinit var context: Context
    lateinit var prefs: SharedPreferences;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login1)
            val db = DatabaseHelper(this)

        context = this;
        prefs = defaultPrefs(this)
        LoginViewModel =
            ViewModelProvider(this, UserRepositoryFactory()).get(LoginViewModel1::class.java)

        text_sign_in.setOnClickListener(this)
        /*Login API Request */

        LoginViewModel.execureLoginRespose().observe(this, Observer { api ->
            var gson: Gson;
            gson = Gson();
            when (api.status) {
                Status.SUCCESS -> {
                    hideOverlay(supportFragmentManager)
                    println("DEBUG: ${api.data}")
                   prefs = defaultPrefs(this)
                  /*  empdetails = gson.fromJson(api.data, Employee::class.java)
                    prefs[Constant.EMPLOYEE_CODE] = api.data.toString();*/
                    val empjson: String? = prefs[Constant.EMPLOYEE_CODE]

                    empdetails = gson.fromJson(api.data, UserProfileMain::class.java)
                 /*   db.munuListDao().insertAll( empdetails.menuList.get(1))
                   val  data = db.munuListDao().getDogsAndOwners()

                    data?.forEach {
                        println(it)
                    }*/
                 //   callMainActivity()

                }
                Status.ERROR -> {
                    hideOverlay(supportFragmentManager)
                    println("DEBUG: ${api.error}")
                }

            }

        })


        /* trveller aPI request */
        /* travellerDetailsResultDto = TravellerDetailsResultDto();

         LoginViewModel.getTraveller(getHeaderMap(),travellerDetailsResultDto)



         //LoginViewModel.execureRespose().observe(this, this::consumeResponse)
         LoginViewModel.execureRespose().observe(this, Observer {
             println("DEBUG: $it")
         })*/
        /*   val prefs= SharedPreferenceManager.defaultPrefs(context)
           prefs.getString("test","")
           prefs.edit().putString("test","sachin");
           prefs.setValue().getString("test","")
           SharedPreferenceManager. = inPassword.text.toString()*/


       /* val prefs = defaultPrefs(this)
        prefs[Constant.EMPLOYEE_NAME] = "any_type_of_value" //setter
        val value: String? = prefs[Constant.EMPLOYEE_NAME] //getter*/

        // val anotherValue: Int? = prefs[Consts.SharedPrefs.KEY, 10] //getter with default value

    }

 fun callMainActivity(){
      intent = Intent(context, MainActivity::class.java)
     startActivity(intent)
     finish()
 }
    private fun getHeaderMap(): Map<String, String> {
        val headerMap = mutableMapOf<String, String>()
        headerMap["x-auth-token"] =
            "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXlhdGkubWVodGFAYXVyaW9ucHJvLmNvbSIsImV4cCI6MTU4NzMwMTQxOH0.m3F-hAR2aJzSs0syw5Q-iUoxEub8veN3aw3Orx9py78"
        return headerMap
    }

    override fun onDestroy() {
        super.onDestroy()
        //LoginViewModel.cancelJobs()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.text_sign_in -> {
                attemptLogin()
            }
        }
    }

    fun attemptLogin() {
        email.setError(null)
        password.setError(null)
        val email1 = email.text.toString()
        val password1 = password.text.toString()
        var cancel: Boolean = false
        var foucus: View? = null

        if (TextUtils.isEmpty(password1)) {
            cancel = true;
            foucus = password
            password.setError("Enter Password!")
        }

        if (TextUtils.isEmpty(email1)) {
            email.setError("Enter Email Id")
            cancel = true
            foucus = email
        }


        if (cancel) {
            foucus?.requestFocus()
        } else {
            showOverlay(supportFragmentManager)
            loginrequest = LoginRequest(email1, md5(password1))
            LoginViewModel.login(loginrequest)
        }
    }
}
