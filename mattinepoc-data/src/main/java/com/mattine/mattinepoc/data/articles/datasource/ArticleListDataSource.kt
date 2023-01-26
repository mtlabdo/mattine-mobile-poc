package com.mattine.mattinepoc.data.articles.datasource

import com.mattine.mattinepoc.data.articles.model.ArticleDataModel

interface ArticleListDataSource {

    suspend fun articleList(categoryId: Int): List<ArticleDataModel>
}