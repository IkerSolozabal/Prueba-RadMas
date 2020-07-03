package com.example.weather.data.repository

import com.example.weather.data.model.Weather

interface RemoteRepository {
    suspend fun getWeatherListByLocation(): List<Weather>
}