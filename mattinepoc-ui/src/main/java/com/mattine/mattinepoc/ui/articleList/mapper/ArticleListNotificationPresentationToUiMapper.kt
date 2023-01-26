package com.mattine.mattinepoc.ui.articleList.mapper

import com.mattine.mattinepoc.presentation.articleList.model.ArticleListPresentationNotification
import com.mattine.mattinepoc.ui.architecture.mapper.NotificationPresentationToUiMapper
import com.mattine.mattinepoc.ui.architecture.model.NotificationUiModel

class ArticleListNotificationPresentationToUiMapper :
    NotificationPresentationToUiMapper<ArticleListPresentationNotification> {

    override fun toUi(presentationNotification: ArticleListPresentationNotification): NotificationUiModel {
        TODO("No notifications implemented for the article list screen.")
    }
}