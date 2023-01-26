package com.mattine.poc.navigation.mapper

import androidx.navigation.NavController
import com.mattine.mattinepoc.presentation.architecture.mdoel.PresentationDestination
import com.mattine.mattinepoc.ui.navigation.mapper.DestinationPresentationToUiMapper
import com.mattine.mattinepoc.ui.navigation.model.UiDestination
import com.mattine.poc.navigation.model.UnhandledDestinationException
import dagger.Lazy

class GlobalDestinationToUiMapper(
    private val lazyNavController: Lazy<NavController>
) : DestinationPresentationToUiMapper {
    override fun toUi(
        input: PresentationDestination
    ): UiDestination = when (input) {
        PresentationDestination.Back -> BackUiDestination(lazyNavController)
        else -> throw UnhandledDestinationException(input)
    }

    private class BackUiDestination(
        private val lazyNavController: Lazy<NavController>
    ) : UiDestination {
        override fun navigate() {
            lazyNavController.get().popBackStack()
        }
    }
}
