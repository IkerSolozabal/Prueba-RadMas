package com.example.weather.weatherList

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.R
import com.example.weather.data.model.Weather
import kotlinx.android.synthetic.main.activity_weather_list.*

class WeatherListActivity : AppCompatActivity(), WeatherListPresenter.View {

    val presenter = WeatherListPresenter(this)
    val adapter = WeatherListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_list)

        weatherList.layoutManager = LinearLayoutManager(this)
        weatherList.setHasFixedSize(true)
        weatherList.adapter = adapter
        weatherList.addItemDecoration(
            DividerItemDecoration(
                this,
                (weatherList.layoutManager as LinearLayoutManager).orientation
            )
        )

        //swipeRefresh.isRefreshing = true
        swipeRefresh.setOnRefreshListener {
            presenter.onRefresh()

        }
        presenter.init()

    }

    override fun showWeatherList(weatherData: List<Weather>) {
        adapter.addItems(weatherData)
        swipeRefresh.visibility = View.VISIBLE
        weatherList.visibility = View.VISIBLE
        swipeRefresh.isRefreshing = false
        loadingBar.visibility = View.GONE
    }

    override fun hideWeatherList() {
        weatherList.visibility = View.GONE
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        loadingBar.visibility = View.GONE
        swipeRefresh.isRefreshing = false
        swipeRefresh.visibility = View.VISIBLE

    }
}
