package com.mattine.mattinepoc.datasource.articles.network

import com.mattine.mattinepoc.datasource.articles.model.ArticleNetworkModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleApi {

    @GET("api/articles")
    suspend fun getByCategory(@Query("categoryId") categoryId: Int): Response<List<ArticleNetworkModel>?>
}