package com.example.mvvmpr.model

interface BaseResponse<T> {

    fun onSuccess(data: T)

    fun onError(throwable: Throwable)
}