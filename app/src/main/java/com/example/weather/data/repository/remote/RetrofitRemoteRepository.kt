package com.example.weather.data.repository.remote

import android.accounts.NetworkErrorException
import com.example.weather.data.model.Weather
import com.example.weather.data.network.WeatherApiFatory
import com.example.weather.data.repository.RemoteRepository

class RetrofitRemoteRepository : RemoteRepository {

    private val weatherApi = WeatherApiFatory.get()

    override suspend fun getWeatherListByLocation(): List<Weather> {
        try {
            val response = weatherApi.getWeatherByLocation()
                ?: throw NetworkErrorException("Error fetching weather for location")
            return response.weatherList

        } catch (e: Exception) {
            throw NetworkErrorException("Error fetching weather data")
            //return emptyList()
        }

    }

}