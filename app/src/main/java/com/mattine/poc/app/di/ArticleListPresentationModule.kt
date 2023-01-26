package com.mattine.poc.app.di

import com.mattine.mattinepoc.domain.cleanarchitecture.articles.repository.ArticleListRepository
import com.mattine.mattinepoc.domain.cleanarchitecture.articles.usecase.GetArticleListUseCase
import com.mattine.mattinepoc.domain.cleanarchitecture.coroutine.CoroutineContextProvider
import com.mattine.mattinepoc.presentation.articleList.mapper.ArticleDomainToPresentationMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ArticleListPresentationModule {

    @Provides
    fun providesGetArticleListUseCase(
        coroutineContextProvider: CoroutineContextProvider,
        articleListRepository: ArticleListRepository
    ): GetArticleListUseCase =
        GetArticleListUseCase(articleListRepository, coroutineContextProvider)

    @Provides
    fun providesArticleDomainToPresentationMapper(): ArticleDomainToPresentationMapper =
        ArticleDomainToPresentationMapper()


}