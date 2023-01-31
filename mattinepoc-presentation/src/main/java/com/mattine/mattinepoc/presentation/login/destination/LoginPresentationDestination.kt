package com.mattine.mattinepoc.presentation.login.destination

import com.mattine.mattinepoc.presentation.architecture.mdoel.PresentationDestination
import com.mattine.mattinepoc.presentation.login.model.LoggedUserPresentationModel

sealed interface LoginPresentationDestination : PresentationDestination {
    data class UserLoginSuccess(
        val loggedUser: LoggedUserPresentationModel
    ) : LoginPresentationDestination

}