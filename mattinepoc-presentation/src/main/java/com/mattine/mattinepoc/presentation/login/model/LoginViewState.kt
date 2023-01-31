package com.mattine.mattinepoc.presentation.login.model

data class LoginViewState(
    val isLoading: Boolean = false
) {

    fun loading() = copy(isLoading = true)

    fun idle() = copy(isLoading = false)
}