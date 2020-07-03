package com.example.weather.weatherList

import android.accounts.NetworkErrorException
import com.example.weather.data.model.Weather
import com.example.weather.data.network.WeatherApiFatory
import com.example.weather.data.repository.RemoteRepository
import com.example.weather.data.repository.remote.RetrofitRemoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherListPresenter(private val view: View) {

    private val remoteRepository: RemoteRepository =
        RetrofitRemoteRepository() //weatherApi = WeatherApiFatory.get()

    fun init() {

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val weatherList = withContext(Dispatchers.IO) {
                    remoteRepository.getWeatherListByLocation()
                }


                view.showWeatherList(weatherList)
            } catch (e: NetworkErrorException) {
                view.showError(e.message!!)
            }
        }
    }

    fun onRefresh() {
        view.hideWeatherList()
        init()
    }

    interface View {
        fun showWeatherList(weatherData: List<Weather>)
        fun hideWeatherList()
        fun showError(message: String)
    }

}