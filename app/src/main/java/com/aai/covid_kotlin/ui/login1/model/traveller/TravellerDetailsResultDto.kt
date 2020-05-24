package com.aai.covid_kotlin.ui.login1.model.traveller

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TravellerDetailsResultDto {
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("travellerName")
    @Expose
    var travellerName: String? = null
    @SerializedName("travellerAge")
    @Expose
    var travellerAge: Int? = null
    @SerializedName("travellerAddress")
    @Expose
    var travellerAddress: String? = null
    @SerializedName("travellerCountryOfOrgin")
    @Expose
    var travellerCountryOfOrgin: String? = null
    @SerializedName("travellingSource")
    @Expose
    var travellingSource: String? = null
    @SerializedName("travellingDestination")
    @Expose
    var travellingDestination: String? = null
    @SerializedName("travellingStartDate")
    @Expose
    var travellingStartDate: Long? = null
    @SerializedName("pnrNumber")
    @Expose
    var pnrNumber: String? = null
    @SerializedName("travellerFlightNumber")
    @Expose
    var travellerFlightNumber: String? = null
    @SerializedName("travellerArrivalDate")
    @Expose
    var travellerArrivalDate: Long? = null
    @SerializedName("travellerBodyTemp")
    @Expose
    var travellerBodyTemp: Int? = null
    @SerializedName("createdDate")
    @Expose
    var createdDate: Long? = null
    @SerializedName("lastUpdatedBy")
    @Expose
    var lastUpdatedBy: String? = null
    @SerializedName("lastUpdated")
    @Expose
    var lastUpdated: String? = null
    @SerializedName("createdBy")
    @Expose
    var createdBy: String? = null
    @SerializedName("countrySensitivityLevel")
    @Expose
    var countrySensitivityLevel: String? = null
    @SerializedName("familyMemberCount")
    @Expose
    var familyMemberCount: Int? = null
    @SerializedName("medicalHistory")
    @Expose
    var medicalHistory: String? = null

}