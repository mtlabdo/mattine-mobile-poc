package com.mattine.mattinepoc.ui.login.mapper

import com.mattine.mattinepoc.presentation.login.model.LoggedUserPresentationModel
import com.mattine.mattinepoc.ui.navigation.mapper.DestinationPresentationToUiMapper
import com.mattine.mattinepoc.ui.navigation.model.UiDestination

interface LoginDestinationToUiMapper : DestinationPresentationToUiMapper {

    abstract class LoginSuccessUiDestination(
        open val loggedUser: LoggedUserPresentationModel
    ) : UiDestination
}