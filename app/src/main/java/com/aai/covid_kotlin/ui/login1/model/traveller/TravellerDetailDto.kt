package com.aai.covid_kotlin.ui.login1.model.traveller

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TravellerDetailDto {
    @SerializedName("searchResults")
    @Expose
    var searchResults: List<TravellerDetailsResultDto>? = null
    @SerializedName("count")
    @Expose
    var count: Int? = null

}