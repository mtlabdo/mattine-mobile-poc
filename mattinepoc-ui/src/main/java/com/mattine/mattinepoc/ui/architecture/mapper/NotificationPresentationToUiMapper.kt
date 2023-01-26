package com.mattine.mattinepoc.ui.architecture.mapper

import com.mattine.mattinepoc.ui.architecture.model.NotificationUiModel

interface NotificationPresentationToUiMapper<PRESENTATION_NOTIFICATION: Any> {

    fun toUi(presentationNotification: PRESENTATION_NOTIFICATION): NotificationUiModel
}