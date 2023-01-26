package com.mattine.mattinepoc.ui.articleList.view

import androidx.recyclerview.widget.RecyclerView
import com.mattine.mattinepoc.ui.architecture.view.ViewsProvider

interface ArticleListViewsProvider : ViewsProvider {
    val articleListView: RecyclerView
}