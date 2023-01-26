package com.mattine.mattinepoc.domain.cleanarchitecture.articles.usecase

import com.mattine.mattinepoc.domain.cleanarchitecture.articles.model.ArticleDomainModel
import com.mattine.mattinepoc.domain.cleanarchitecture.articles.repository.ArticleListRepository
import com.mattine.mattinepoc.domain.cleanarchitecture.coroutine.CoroutineContextProvider
import com.mattine.mattinepoc.domain.cleanarchitecture.usecase.BackgroundExecutingUseCase

class GetArticleListUseCase(
    private val articleListRepository: ArticleListRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<Int, List<ArticleDomainModel>>(coroutineContextProvider) {

    override suspend fun executeInBackground(request: Int) = articleListRepository.articleList(request)
}