package com.mattine.poc.app.di.articles

import com.mattine.mattinepoc.data.articles.datasource.ArticleListDataSource
import com.mattine.mattinepoc.data.articles.mapper.ArticleDataToDomainMapper
import com.mattine.mattinepoc.data.articles.repository.ArticleListLiveRepository
import com.mattine.mattinepoc.domain.cleanarchitecture.articles.repository.ArticleListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ArticleListDataModule {

    @Provides
    fun providesArticleDataToDomainMapper(): ArticleDataToDomainMapper = ArticleDataToDomainMapper()

    @Provides
    fun providesArticleListRepository(
        articleListDataSource: ArticleListDataSource,
        articleDataToDomainMapper: ArticleDataToDomainMapper,
    ): ArticleListRepository =
        ArticleListLiveRepository(articleListDataSource, articleDataToDomainMapper)
}