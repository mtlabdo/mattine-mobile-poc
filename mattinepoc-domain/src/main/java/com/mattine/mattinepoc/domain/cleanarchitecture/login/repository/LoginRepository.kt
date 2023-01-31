package com.mattine.mattinepoc.domain.cleanarchitecture.login.repository

import com.mattine.mattinepoc.domain.cleanarchitecture.login.model.LoggedUserDomainModel

interface LoginRepository {

    fun login(password: String): LoggedUserDomainModel
}

class LoginDummyRepository : LoginRepository {

    override fun login(password: String) = LoggedUserDomainModel(
        id = "1",
        firstName = "Abdo",
        lastName = "mtl",
        state = true
    )
}