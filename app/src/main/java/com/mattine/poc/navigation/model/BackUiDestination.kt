package com.mattine.poc.navigation.model

import androidx.navigation.NavController
import com.mattine.mattinepoc.ui.navigation.model.UiDestination
import dagger.Lazy

class BackUiDestination(
    private val lazyNavController: Lazy<NavController>
) : UiDestination {
    override fun navigate() {
        lazyNavController.get().popBackStack()
    }
}
