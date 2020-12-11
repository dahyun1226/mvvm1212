package com.example.mvvmpr.model.api

import com.example.mvvmpr.model.data.Weather
import com.example.mvvmpr.model.data.WeatherData
import retrofit2.http.GET
import io.reactivex.Single
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServiceInterface {

    @GET("/data/2.5/weather")
    fun requestWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String
    ): Single<WeatherData>
}
