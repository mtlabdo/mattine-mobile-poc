package com.mattine.mattinepoc.datasource.articles.datasource

import com.mattine.mattinepoc.data.articles.datasource.ArticleListDataSource
import com.mattine.mattinepoc.data.articles.model.ArticleDataModel
import com.mattine.mattinepoc.datasource.articles.mapper.ArticleNetworkToDataModelMapper
import com.mattine.mattinepoc.datasource.articles.network.ArticleApi
import com.mattine.mattinepoc.datasource.network.utils.StatusCode
import com.mattine.mattinepoc.datasource.network.utils.toHttpStatus

class ArticleListLiveDataSource(
    private val articleNetworkToDataModelMapper: ArticleNetworkToDataModelMapper,
    private val articleApi: ArticleApi
) : ArticleListDataSource {

    override suspend fun articleList(categoryId: Int): List<ArticleDataModel> {

        try {
            val response = articleApi.getAll()
            when {
                response.isSuccessful -> {
                    val status = response.body()?.code.toHttpStatus()
                    if (status == StatusCode.OK) {
                        val networkResult = response.body()?.message ?: emptyList()
                        return networkResult.map(articleNetworkToDataModelMapper::toData)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return emptyList()
    }
}