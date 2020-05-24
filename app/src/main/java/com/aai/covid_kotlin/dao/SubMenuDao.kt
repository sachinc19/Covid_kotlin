package com.aai.covid_kotlin.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aai.covid_kotlin.pojomodel.Menu
import com.aai.covid_kotlin.pojomodel.Submenu1

@Dao
interface SubMenuDao{

    @Query("SELECT * FROM submenu")
    fun getAllmenu():List<Submenu1>

    @Insert
    fun  insertAll(vararg munu: Submenu1)


}