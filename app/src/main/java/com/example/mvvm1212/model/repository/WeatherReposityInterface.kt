package com.example.mvvmpr.model.repository

import com.example.mvvmpr.model.BaseResponse
import com.example.mvvmpr.model.data.WeatherData
import io.reactivex.disposables.Disposable

interface WeatherRepositoryInterface {
    fun getWeather(
        callback: BaseResponse<WeatherData>
    ): Disposable
}