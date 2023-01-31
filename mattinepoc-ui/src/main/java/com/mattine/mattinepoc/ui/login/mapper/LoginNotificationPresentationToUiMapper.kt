package com.mattine.mattinepoc.ui.login.mapper

import com.mattine.mattinepoc.presentation.login.model.LoginPresentationNotification
import com.mattine.mattinepoc.ui.architecture.mapper.NotificationPresentationToUiMapper
import com.mattine.mattinepoc.ui.architecture.model.NotificationUiModel

class LoginNotificationPresentationToUiMapper :
    NotificationPresentationToUiMapper<LoginPresentationNotification> {
    override fun toUi(presentationNotification: LoginPresentationNotification): NotificationUiModel {
        throw IllegalStateException("Notifications not supported.")
    }
}