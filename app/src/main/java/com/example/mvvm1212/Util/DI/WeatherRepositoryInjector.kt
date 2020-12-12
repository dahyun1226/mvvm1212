package com.example.mvvmpr.Util.DI

import com.example.mvvmpr.model.api.RetrofitServiceImpl
import com.example.mvvmpr.model.repository.WeatherRepositoryImpl
import com.example.mvvmpr.model.repository.WeatherRepositoryInterface

object WeatherRepositoryInjector {

    fun provideWeatherRepository(): WeatherRepositoryInterface {

        return WeatherRepositoryImpl(RetrofitServiceImpl.getService())

    }
}