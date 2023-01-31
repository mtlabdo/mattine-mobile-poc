package com.mattine.poc.app.di.login

import com.mattine.mattinepoc.presentation.login.model.LoginViewState
import com.mattine.mattinepoc.ui.architecture.mapper.ViewStateBinder
import com.mattine.mattinepoc.ui.architecture.view.ViewsProvider
import com.mattine.mattinepoc.ui.login.binder.LoginViewStateBinder
import com.mattine.mattinepoc.ui.login.mapper.LoginNotificationPresentationToUiMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
class LoginUiModule {

    @Provides
    @Suppress("UNCHECKED_CAST")
    fun providesLoginStateBinder() =
        LoginViewStateBinder() as ViewStateBinder<LoginViewState, ViewsProvider>

    @Provides
    fun providesLoginNotificationPresentationToUiMapper() =
        LoginNotificationPresentationToUiMapper()
}