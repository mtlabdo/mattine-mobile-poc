package com.mattine.mattinepoc.presentation.articleList.model


data class ArticleListViewState(
    val isLoading: Boolean = false,
    val articles: List<ArticlePresentationModel> = listOf()
) {

    fun loading() = copy(isLoading = true)

    fun withArticles(
        articles: List<ArticlePresentationModel>
    ) = copy(isLoading = false, articles = articles)
}