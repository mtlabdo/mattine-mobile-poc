package com.mattine.poc.app.di

import androidx.fragment.app.Fragment
import com.mattine.mattinepoc.presentation.articleList.model.ArticleListViewState
import com.mattine.mattinepoc.ui.architecture.mapper.ViewStateBinder
import com.mattine.mattinepoc.ui.architecture.view.ViewsProvider
import com.mattine.mattinepoc.ui.articleList.bidner.ArticleListViewStateBinder
import com.mattine.mattinepoc.ui.articleList.mapper.ArticleListNotificationPresentationToUiMapper
import com.mattine.mattinepoc.ui.articleList.mapper.ArticlePresentationToUiMapper
import com.mattine.mattinepoc.ui.articleList.view.ArticleListFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
class ArticleListUiModule {


    @Provides
    @Suppress("UNCHECKED_CAST")
    fun providesArticleListViewStateBinder(
        fragment: Fragment,
        articlePresentationToUiMapper: ArticlePresentationToUiMapper
    ) = ArticleListViewStateBinder(
        fragment as ArticleListFragment,
        articlePresentationToUiMapper
    ) as ViewStateBinder<ArticleListViewState, ViewsProvider>


    @Provides
    fun providesArticleListNotificationPresentationToUiMapper(): ArticleListNotificationPresentationToUiMapper =
        ArticleListNotificationPresentationToUiMapper()

    @Provides
    fun providesArticlePresentationToUiMapper(): ArticlePresentationToUiMapper =
        ArticlePresentationToUiMapper()
}