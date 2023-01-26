package com.mattine.poc.app.di

import android.content.Context
import com.mattine.mattinepoc.datasource.retrofit.ApiService
import com.mattine.mattinepoc.datasource.retrofit.RetrofitClient
import com.mattine.mattinepoc.datasource.retrofit.SafeHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesSafeHttpClient(@ApplicationContext appContext: Context) = SafeHttpClient(appContext)

    @Provides
    @Singleton
    fun providesOkHttpClient(safeHttpClient: SafeHttpClient): OkHttpClient =
        safeHttpClient.createOkHttpClient()


    @Provides
    fun providesRetrofitClient(okHttpClient: OkHttpClient) = RetrofitClient(okHttpClient)

    @Provides
    @Singleton
    fun providesRetrofit(retrofitClient: RetrofitClient): Retrofit =
        retrofitClient.createRetrofit()
/*
    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): ApiService =
        ApiService(retrofit)*/
}