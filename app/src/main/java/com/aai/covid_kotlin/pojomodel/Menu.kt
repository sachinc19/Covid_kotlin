package com.aai.covid_kotlin.pojomodel


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "menulist")
data class Menu(
    @SerializedName("deleteRight")
    val deleteRight: String,
    @SerializedName("editRight")
    val editRight: String,
    @SerializedName("imgAttachmentFilePath")
    val imgAttachmentFilePath: String,
    @SerializedName("menuName")
    @PrimaryKey
    val menuName: String,
    @SerializedName("pageUrl")
    val pageUrl: String,
    @SerializedName("subMenuDto")
    val subMenuDto:List<Submenu1>,
    @SerializedName("title")
    val title: String,
    @SerializedName("viewRight")
    val viewRight: String
)