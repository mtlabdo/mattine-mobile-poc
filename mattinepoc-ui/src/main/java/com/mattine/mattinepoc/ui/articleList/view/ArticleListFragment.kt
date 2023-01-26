package com.mattine.mattinepoc.ui.articleList.view

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.mattine.mattinepoc.presentation.articleList.model.ArticleListViewState
import com.mattine.mattinepoc.ui.architecture.view.BaseFragment
import com.mattine.mattinepoc.ui.articleList.bidner.ArticleListViewStateBinder
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.mattine.mattinepoc.presentation.articleList.model.ArticleListPresentationNotification
import com.mattine.mattinepoc.presentation.articleList.viewModel.ArticleListViewModel
import com.mattine.mattinepoc.ui.architecture.mapper.ViewStateBinder
import com.mattine.mattinepoc.ui.architecture.view.ViewsProvider
import com.mattine.mattinepoc.ui.articleList.mapper.ArticleDestinationToUiMapper
import com.mattine.mattinepoc.ui.articleList.mapper.ArticleListNotificationPresentationToUiMapper
import com.mattine.poc.ui.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArticleListFragment :
    BaseFragment<ArticleListViewState, ArticleListPresentationNotification>(),
    ArticleListViewsProvider,
    ArticleListViewStateBinder.OnClickListener {

    override val viewModel: ArticleListViewModel by viewModels()

    @Inject
    override lateinit var destinationMapper: ArticleDestinationToUiMapper

    @Inject
    @JvmSuppressWildcards
    override lateinit var viewStateBinder: ViewStateBinder<ArticleListViewState, ViewsProvider>

    @Inject
    override lateinit var notificationMapper: ArticleListNotificationPresentationToUiMapper

    override val layoutResourceId = R.layout.fragment_article_list

    override lateinit var articleListView: RecyclerView

    private val categoryId by lazy {
        requireNotNull(
            requireArguments().getInt(ARGUMENT_CATEGORY_ID, -1)
        ) { "A category id must be provided." }
    }

    override fun View.bindViews() {
        articleListView = findViewById(R.id.article_list)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            viewModel.onEntered(categoryId)
        }
    }

    override fun onArticleClick(articleId: String) {
        TODO("Not yet implemented")
    }

    companion object {
        private const val ARGUMENT_CATEGORY_ID = "CategoryId"

        fun newInstance(categoryId: Int): ArticleListFragment {
            val args = bundleOf(ARGUMENT_CATEGORY_ID to categoryId)
            val fragment = ArticleListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}