package com.example.mvvmpr.Util.DI

import com.example.mvvmpr.model.api.RetrofitService
import com.example.mvvmpr.model.repository.WeatherRepository
import com.example.mvvmpr.model.repository.WeatherRepositoryInterface

object WeatherRepositoryInjector {

    fun provideWeatherRepository(): WeatherRepositoryInterface {

        return WeatherRepository(RetrofitService.getService())

    }
}