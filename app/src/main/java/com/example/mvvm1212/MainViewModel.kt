package com.example.mvvm1212

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm1212.Util.Event.Event
import com.example.mvvmpr.model.BaseResponse
import com.example.mvvmpr.model.data.WeatherData
import com.example.mvvmpr.model.repository.WeatherRepositoryInterface
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(
    private val repository: WeatherRepositoryInterface,
    private val compositeDisposable: CompositeDisposable
) {

    //val currentWeather = ObservableField("Check Weather")

    private val _currentWeather = MutableLiveData<String>("current")
    val currentWeather: LiveData<String> = _currentWeather

    fun getWeather() {
        repository.getWeather(object : BaseResponse<WeatherData> {
            override fun onSuccess(data: WeatherData) {
                //currentWeather.set(data.weather[0].description)
                _currentWeather.value = data.weather[0].description
            }

            override fun onError(throwable: Throwable) {
                //currentWeather.set(throwable.toString())
                _currentWeather.value = throwable.toString()
            }

        }).also { compositeDisposable.add(it) }
    }
}