package com.mattine.mattinepoc.domain.cleanarchitecture.articles.repository

import com.mattine.mattinepoc.domain.cleanarchitecture.articles.model.ArticleDomainModel

interface ArticleListRepository {

    suspend fun articleList(idCategory: Int): List<ArticleDomainModel>
}
