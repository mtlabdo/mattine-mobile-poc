package com.mattine.mattinepoc.datasource.retrofit

import retrofit2.Retrofit

class ApiService(val retrofit: Retrofit) {
    inline fun <reified T> getApiService(): T {
        return retrofit.create(T::class.java)
    }
}