package com.mattine.mattinepoc.ui.login.binder

import android.view.View
import com.mattine.mattinepoc.presentation.login.model.LoginViewState
import com.mattine.mattinepoc.ui.architecture.mapper.ViewStateBinder
import com.mattine.mattinepoc.ui.login.view.LoginViewsProvider

class LoginViewStateBinder : ViewStateBinder<LoginViewState, LoginViewsProvider> {

    override fun LoginViewsProvider.bindState(viewState: LoginViewState) {
        progressView.visibility = if (viewState.isLoading) View.VISIBLE else View.GONE
    }
}