package com.aai.covid_kotlin.pojomodel


import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.aai.covid_kotlin.ui.login1.model.User
import com.google.gson.annotations.SerializedName
@Entity(tableName = "submenu"/*,foreignKeys = arrayOf(
    ForeignKey(entity = Menu::class,
        parentColumns = arrayOf("menuName"),
        childColumns = arrayOf("menuName"))
)*/)
data class Submenu1(
    @SerializedName("deleteRight")
    val deleteRight: String,
    @SerializedName("editRight")
    val editRight: String,
    @SerializedName("imgAttachmentFilePath")
    val imgAttachmentFilePath: String,
    @SerializedName("pageUrl")
    val pageUrl: String,
    @SerializedName("subMenuName")
    @PrimaryKey
    val subMenuName: String,
    @SerializedName("viewRight")
    val viewRight: String,

    @SerializedName("menuName")
val menuName: String
)