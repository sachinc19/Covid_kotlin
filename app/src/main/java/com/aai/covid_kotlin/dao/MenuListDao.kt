package com.aai.covid_kotlin.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.aai.covid_kotlin.pojomodel.Menu
import com.aai.covid_kotlin.pojomodel.MunuWithSubmenu
import com.aai.covid_kotlin.pojomodel.Submenu1
import com.aai.covid_kotlin.ui.login1.model.User

@Dao
interface MenuListDao{

    @Query("SELECT * FROM menulist")
    fun getAllmenu():List<Menu>

    @Insert
    fun  insertAll(vararg munu: Menu)

    @Transaction
    @Query("SELECT * FROM menulist")
    fun getDogsAndOwners(): List<MunuWithSubmenu>


    @Transaction
    open fun updateData(users: List<Menu>) {
        deleteAllUsers()
        insertAll(users)
    }
    @Insert
    abstract fun insertAll(users: List<Menu>)

    @Query("DELETE FROM menulist")
    abstract fun deleteAllUsers()
}