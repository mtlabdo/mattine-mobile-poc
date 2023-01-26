package com.mattine.mattinepoc.data.articles.repository

import com.mattine.mattinepoc.data.articles.datasource.ArticleListDataSource
import com.mattine.mattinepoc.data.articles.mapper.ArticleDataToDomainMapper
import com.mattine.mattinepoc.domain.cleanarchitecture.articles.model.ArticleDomainModel
import com.mattine.mattinepoc.domain.cleanarchitecture.articles.repository.ArticleListRepository

class ArticleListLiveRepository(
    private val articleListDataSource: ArticleListDataSource,
    private val articleDataToDomainMapper: ArticleDataToDomainMapper
) : ArticleListRepository {

    override suspend fun articleList(idCategory: Int): List<ArticleDomainModel> {
        return articleListDataSource.articleList(idCategory)
            .map(articleDataToDomainMapper::toDomain)
    }
}