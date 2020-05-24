package com.aai.covid_kotlin.pojomodel

import androidx.room.Embedded
import androidx.room.Relation

data class MunuWithSubmenu(
@Embedded
val user: Menu,
@Relation(
    parentColumn = "menuName",
    entityColumn = "menuName"
)
val playlists: List<Submenu1>)