package com.mattine.mattinepoc.datasource.retrofit

import android.content.Context
import android.util.Log
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File

class SafeHttpClient(
    private val applicationContext: Context
) {

    fun createOkHttpClient(): OkHttpClient {
        val httpCacheDirectory = File(applicationContext.cacheDir, "responses")
        val cacheSize = 10L * 1024 * 1024 // 10 MiB
        val cache = Cache(httpCacheDirectory, cacheSize)

        return OkHttpClient.Builder().cache(cache).addInterceptor(getLoggingInterceptor()).build()
    }

    private fun getLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

}