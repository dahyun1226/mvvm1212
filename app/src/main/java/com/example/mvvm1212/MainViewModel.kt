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


    fun getWeather() {
        repository.getWeather(object : BaseResponse<WeatherData> {
            override fun onSuccess(data: WeatherData) {

            }

            override fun onError(throwable: Throwable) {

            }

        }).also { compositeDisposable.add(it) }
    }
}