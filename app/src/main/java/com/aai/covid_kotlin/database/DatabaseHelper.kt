package com.aai.covid_kotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aai.covid_kotlin.dao.MenuListDao
import com.aai.covid_kotlin.dao.SubMenuDao
import com.aai.covid_kotlin.pojomodel.Menu
import com.aai.covid_kotlin.pojomodel.Submenu1

@Database(entities = [Menu::class,Submenu1::class],version = 1)
abstract class DatabaseHelper : RoomDatabase(){

    abstract fun munuListDao():MenuListDao
    abstract fun submenuList():SubMenuDao

    companion object {

        @Volatile private var instance: DatabaseHelper? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            DatabaseHelper::class.java, "todo-list.db")
            .build()
    }
}