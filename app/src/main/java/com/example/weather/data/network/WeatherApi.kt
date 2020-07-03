package com.example.weather.data.network

import com.example.weather.data.model.Weather
import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast?id=524901&appid=439d4b804bc8187953eb36d2a8c26a02")
    suspend fun getWeatherByLocation(): WeatherResponse?
}

data class WeatherResponse(
    @SerializedName("list")
    val weatherList: List<Weather>
)

object WeatherApiFatory {
    fun get(): WeatherApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://samples.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(WeatherApi::class.java)
    }
}