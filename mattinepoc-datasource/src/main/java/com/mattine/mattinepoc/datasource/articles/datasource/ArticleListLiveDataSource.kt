package com.mattine.mattinepoc.datasource.articles.datasource

import android.util.Log
import com.mattine.mattinepoc.data.articles.datasource.ArticleListDataSource
import com.mattine.mattinepoc.data.articles.model.ArticleDataModel
import com.mattine.mattinepoc.datasource.articles.mapper.ArticleNetworkToDataModelMapper
import com.mattine.mattinepoc.datasource.articles.model.ArticleNetworkModel
import com.mattine.mattinepoc.datasource.articles.network.ArticleApi
import com.mattine.mattinepoc.datasource.retrofit.ApiService
import com.mattine.mattinepoc.datasource.retrofit.RetrofitClient
import okhttp3.OkHttpClient

class ArticleListLiveDataSource(
    private val articleNetworkToDataModelMapper: ArticleNetworkToDataModelMapper,
    private val okHttpClient: OkHttpClient
) : ArticleListDataSource {


    private val articleApi = ApiService(RetrofitClient(okHttpClient).createRetrofit()).getApiService<ArticleApi>()

    override suspend fun articleList(categoryId: Int): List<ArticleDataModel> {

        try {

            val resultNetwork = articleApi.getByCategory(1)

            Log.d("resultNetwork", resultNetwork.message())

        } catch (e : Exception){

            e.printStackTrace()
        }

        val articlesNetworkModel = listOf<ArticleNetworkModel>(
            ArticleNetworkModel(
                matricule = "M1",
                idCategory = 1,
                nom = "A1",
                information = "Info1",
                qteMax = null,
                qteMin = null,
                prixVente = 20.00,
                image = null,
                etat = true
            )
        )

        return articlesNetworkModel.map(articleNetworkToDataModelMapper::toData)
    }
}