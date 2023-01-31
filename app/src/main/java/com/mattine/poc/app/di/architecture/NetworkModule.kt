package com.mattine.poc.app.di.architecture

import android.content.Context
import com.mattine.mattinepoc.datasource.network.*
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
    fun providesOkHttpClient(safeHttpClient: SafeHttpClient) =
        safeHttpClient.createOkHttpClient()


    @Provides
    fun providesRetrofitClient(okHttpClient: OkHttpClient) = RetrofitClient(okHttpClient)

    @Provides
    @Singleton
    fun providesRetrofit(retrofitClient: RetrofitClient) =
        retrofitClient.createRetrofit()

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): ApiService =
        ApiService(retrofit)
}