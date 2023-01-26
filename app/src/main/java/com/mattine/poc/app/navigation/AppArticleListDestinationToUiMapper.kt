package com.mattine.poc.app.navigation

import com.mattine.mattinepoc.presentation.architecture.mdoel.PresentationDestination
import com.mattine.mattinepoc.ui.articleList.mapper.ArticleDestinationToUiMapper
import com.mattine.mattinepoc.ui.articleList.mapper.ArticleDestinationToUiMapper.ArticleListUiDestination
import com.mattine.mattinepoc.ui.navigation.model.UiDestination
import com.mattine.poc.navigation.mapper.GlobalDestinationToUiMapper

class AppArticleListDestinationToUiMapper(
    private val globalDestinationToUiMapper: GlobalDestinationToUiMapper
) : ArticleDestinationToUiMapper {

    override fun toUi(input: PresentationDestination): UiDestination = when (input) {
        else -> globalDestinationToUiMapper.toUi(input)
    }

    object GoNowhere : ArticleListUiDestination {
        override fun navigate() = Unit
    }
}