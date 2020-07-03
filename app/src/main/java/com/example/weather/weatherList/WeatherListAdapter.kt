package com.example.weather.weatherList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.data.model.Weather
import com.squareup.picasso.Picasso

class WeatherListAdapter : RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder>() {

    private var weatherList: List<Weather> = emptyList()

    fun addItems(weatherList: List<Weather>) {
        this.weatherList = weatherList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weather = weatherList[position]
        holder.bind(weather)
    }

    class WeatherViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {

        private val stateTxt = view.findViewById<TextView>(R.id.stateTxt)
        private val dateTxt = view.findViewById<TextView>(R.id.dateTxt)
        private val maxTempTxt = view.findViewById<TextView>(R.id.maxTempTxt)
        private val minTextTxt = view.findViewById<TextView>(R.id.minTempTxt)
        private val tempTxt = view.findViewById<TextView>(R.id.tempTxt)

        fun bind(weather: Weather) {
            with(weather) {
                dateTxt.text = dateTime

                stateTxt.text = skyWeatherDetail[0].stateDescription

                val maxTempCelsius = temp.maxTemp - 273
                val minTempCelsius = temp.minTemp - 273
                val tempCelcius = temp.actualTemp - 273

                dateTxt.text = dateTime
                maxTempTxt.text = maxTempCelsius.toString()
                minTextTxt.text = minTempCelsius.toString()
                tempTxt.text = tempCelcius.toString()

            }
        }

        companion object {
            fun from(parent: ViewGroup): WeatherViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.weather_item, parent, false)
                return WeatherViewHolder(view)
            }
        }

    }

}