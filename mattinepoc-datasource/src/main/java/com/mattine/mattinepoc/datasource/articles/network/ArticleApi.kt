package com.mattine.mattinepoc.datasource.articles.network

import com.mattine.mattinepoc.datasource.articles.model.ArticleNetworkModel
import com.mattine.mattinepoc.datasource.model.GenericResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleApi {

    @GET("api/v1/articles")
    suspend fun getAll(): GenericResponse<List<ArticleNetworkModel>?>
    @GET("api/v1/articles")
    suspend fun getByCategory(@Query("idCategory") categoryId: Int): GenericResponse<List<ArticleNetworkModel>?>
}