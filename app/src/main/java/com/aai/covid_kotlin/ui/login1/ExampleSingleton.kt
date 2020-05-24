package com.aai.covid_kotlin.ui.login1

import com.aai.covid_kotlin.ui.login1.model.User

object ExampleSingleton {

    val singletonUser: User by lazy{
        User("mitchelltabian@gmail.com", "mitch", "some_image_url.png")
    }
}