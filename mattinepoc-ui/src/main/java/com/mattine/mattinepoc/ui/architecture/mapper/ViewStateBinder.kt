package com.mattine.mattinepoc.ui.architecture.mapper

import com.mattine.mattinepoc.ui.architecture.view.ViewsProvider

interface ViewStateBinder<in VIEW_STATE : Any, in VIEWS_PROVIDER : ViewsProvider> {

    fun VIEWS_PROVIDER.bindState(viewState: VIEW_STATE)
}