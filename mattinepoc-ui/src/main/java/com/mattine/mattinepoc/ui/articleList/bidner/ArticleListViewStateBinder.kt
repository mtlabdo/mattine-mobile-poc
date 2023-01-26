package com.mattine.mattinepoc.ui.articleList.bidner

import com.mattine.mattinepoc.presentation.articleList.model.ArticleListViewState
import com.mattine.mattinepoc.ui.architecture.mapper.ViewStateBinder
import com.mattine.mattinepoc.ui.articleList.adapter.ArticleListAdapter
import com.mattine.mattinepoc.ui.articleList.mapper.ArticlePresentationToUiMapper
import com.mattine.mattinepoc.ui.articleList.view.ArticleListViewsProvider

class ArticleListViewStateBinder(
    private val onArticleClickListener: OnClickListener,
    private val articleToUiMapper: ArticlePresentationToUiMapper,
) : ViewStateBinder<ArticleListViewState, ArticleListViewsProvider> {

    private val articlesAdapter by lazy {
        ArticleListAdapter().apply {
            onArticleClickListener = _onArticleClickListener
        }
    }

    private val _onArticleClickListener: ArticleListAdapter.OnClickListener =
        DelegateOnClickListener()

    override fun ArticleListViewsProvider.bindState(viewState: ArticleListViewState) {
        if (articleListView.adapter == null) {
            articleListView.adapter = articlesAdapter
        }
        articlesAdapter.setArticles(viewState.articles.map(articleToUiMapper::toUi))
    }

    private inner class DelegateOnClickListener : ArticleListAdapter.OnClickListener {

        override fun onArticleClick(articleId: String) {
            onArticleClickListener.onArticleClick(articleId = articleId)
        }
    }

    interface OnClickListener {
        fun onArticleClick(articleId: String)
    }
}