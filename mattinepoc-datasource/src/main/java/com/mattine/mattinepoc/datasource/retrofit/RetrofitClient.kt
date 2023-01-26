package com.mattine.mattinepoc.datasource.retrofit

import com.mattine.mattinepoc.datasource.retrofit.config.ApiConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient(
    private val okHttpClient: OkHttpClient,
) {

    fun createRetrofit(): Retrofit {
        val baseurl = ApiConfig.BASE_URL
        return Retrofit.Builder()
            .baseUrl(baseurl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}