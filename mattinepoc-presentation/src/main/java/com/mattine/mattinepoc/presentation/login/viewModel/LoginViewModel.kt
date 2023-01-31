package com.mattine.mattinepoc.presentation.login.viewModel

import com.mattine.mattinepoc.domain.cleanarchitecture.login.model.LoggedUserDomainModel
import com.mattine.mattinepoc.domain.cleanarchitecture.login.usecase.LoginUseCase
import com.mattine.mattinepoc.presentation.architecture.viewmodel.BaseViewModel
import com.mattine.mattinepoc.presentation.architecture.viewmodel.usecase.UseCaseExecutorProvider
import com.mattine.mattinepoc.presentation.login.destination.LoginPresentationDestination.UserLoginSuccess
import com.mattine.mattinepoc.presentation.login.mapper.LoggedUserDomainToPresentationMapper
import com.mattine.mattinepoc.presentation.login.model.LoginPresentationNotification
import com.mattine.mattinepoc.presentation.login.model.LoginViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private typealias DoNothing = Unit

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val loggedUserDomainToPresentationMapper: LoggedUserDomainToPresentationMapper,
    useCaseExecutorProvider: UseCaseExecutorProvider
) :
    BaseViewModel<LoginViewState, LoginPresentationNotification>(
        useCaseExecutorProvider
    ) {

    override fun initialState() = LoginViewState()

    fun onLogin(password: String) {
        updateViewState(LoginViewState::loading)
        checkUserLogin(password)
    }

    private fun checkUserLogin(password: String) {
        execute(
            loginUseCase,
            password,
            onSuccess = { user -> logUser(user) },
            onException = { DoNothing }
        )
    }

    private fun logUser(user: LoggedUserDomainModel) {
        updateViewState(LoginViewState::idle)
        val loggedUser = loggedUserDomainToPresentationMapper.toPresentation(user)
        navigateTo(UserLoginSuccess(loggedUser))
    }
}