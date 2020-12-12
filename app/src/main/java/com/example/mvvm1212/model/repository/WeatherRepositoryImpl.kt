package com.example.mvvmpr.model.repository

import com.example.mvvmpr.model.BaseResponse
import com.example.mvvmpr.model.api.RetrofitService
import com.example.mvvmpr.model.data.WeatherData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class WeatherRepositoryImpl(private val api: RetrofitService) : WeatherRepositoryInterface {
    companion object {
        const val CITY_NAME = "Seoul"
        const val APP_KEY = "843f8ca34c2ea262208dcb3cce3c8003"
    }

    override fun getWeather(
        callback: BaseResponse<WeatherData>
    ): Disposable {
        return api.requestWeather(CITY_NAME, APP_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback.onSuccess(it)
            }, {
                callback.onError(it)
            })
    }
}