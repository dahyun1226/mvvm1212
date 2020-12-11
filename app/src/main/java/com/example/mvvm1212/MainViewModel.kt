package com.example.mvvm1212

import androidx.databinding.ObservableField
import com.example.mvvmpr.model.BaseResponse
import com.example.mvvmpr.model.data.WeatherData
import com.example.mvvmpr.model.repository.WeatherRepositoryInterface
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(
    private val repository: WeatherRepositoryInterface,
    private val compositeDisposable: CompositeDisposable
) {
    val currentWeather = ObservableField("Check Weather")

    fun getWeather() {
        repository.getWeather(object : BaseResponse<WeatherData> {
            override fun onSuccess(data: WeatherData) {
                currentWeather.set(data.weather[0].description)
            }

            override fun onError(throwable: Throwable) {
                currentWeather.set(throwable.toString())
            }

        }).also { compositeDisposable.add(it) }
    }
}