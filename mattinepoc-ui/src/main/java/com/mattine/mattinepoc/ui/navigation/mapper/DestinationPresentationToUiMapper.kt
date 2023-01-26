package com.mattine.mattinepoc.ui.navigation.mapper

import com.mattine.mattinepoc.presentation.architecture.mdoel.PresentationDestination
import com.mattine.mattinepoc.ui.navigation.model.UiDestination

interface DestinationPresentationToUiMapper {

    fun toUi(input: PresentationDestination): UiDestination
}