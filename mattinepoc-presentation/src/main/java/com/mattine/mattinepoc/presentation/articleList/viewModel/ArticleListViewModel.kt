package com.mattine.mattinepoc.presentation.articleList.viewModel

import com.mattine.mattinepoc.domain.cleanarchitecture.articles.model.ArticleDomainModel
import com.mattine.mattinepoc.domain.cleanarchitecture.articles.usecase.GetArticleListUseCase
import com.mattine.mattinepoc.presentation.architecture.viewmodel.BaseViewModel
import com.mattine.mattinepoc.presentation.architecture.viewmodel.usecase.UseCaseExecutorProvider
import com.mattine.mattinepoc.presentation.articleList.mapper.ArticleDomainToPresentationMapper
import com.mattine.mattinepoc.presentation.articleList.model.ArticleListPresentationNotification
import com.mattine.mattinepoc.presentation.articleList.model.ArticleListViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private typealias DoNothing = Unit

@HiltViewModel
class ArticleListViewModel @Inject constructor(
    private val getArticleListUseCase: GetArticleListUseCase,
    private val articleDomainToPresentationMapper: ArticleDomainToPresentationMapper,
    useCaseExecutorProvider: UseCaseExecutorProvider,
) :
    BaseViewModel<ArticleListViewState, ArticleListPresentationNotification>(useCaseExecutorProvider) {

    override fun initialState() = ArticleListViewState()

    fun onEntered(categoryId: Int) {
        updateViewState(ArticleListViewState::loading)
        fetchArticleList(categoryId)
    }

    private fun fetchArticleList(categoryId: Int) {
        execute(
            getArticleListUseCase,
            categoryId,
            onSuccess = { articles -> presentArticleList(articles) },
            onException = { DoNothing })
    }

    private fun presentArticleList(articleList: List<ArticleDomainModel>) {
        updateViewState {
            withArticles(articleList.map(articleDomainToPresentationMapper::toPresentation))
        }
    }
}