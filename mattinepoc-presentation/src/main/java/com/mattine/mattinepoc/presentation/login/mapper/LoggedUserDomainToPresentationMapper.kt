package com.mattine.mattinepoc.presentation.login.mapper

import com.mattine.mattinepoc.domain.cleanarchitecture.login.model.LoggedUserDomainModel
import com.mattine.mattinepoc.presentation.login.model.LoggedUserPresentationModel

class LoggedUserDomainToPresentationMapper {

    fun toPresentation(input: LoggedUserDomainModel) = LoggedUserPresentationModel(
        id = input.id,
        firstName = input.firstName,
        lastName = input.lastName,
    )
}