package com.example.weather.data.model

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("main")
    val temp: Temp,
    @SerializedName("weather")
    val skyWeatherDetail: List<SkyWeatherDetail>,
    @SerializedName("dt_txt")
    val dateTime: String
)

data class Temp(
    @SerializedName("temp")
    val actualTemp: Float,
    @SerializedName("temp_min")
    val minTemp: Float,
    @SerializedName("temp_max")
    val maxTemp: Float
)

data class SkyWeatherDetail(
    @SerializedName("main")
    val state: String,
    @SerializedName("description")
    val stateDescription: String,
    @SerializedName("icon")
    val stateIcon: String
)

