package com.mattine.mattinepoc.domain.cleanarchitecture.login.repository

import com.mattine.mattinepoc.domain.cleanarchitecture.login.model.LoggedUserDomainModel
import kotlinx.coroutines.delay

interface LoginRepository {

    suspend fun login(password: String): LoggedUserDomainModel
}

class LoginDummyRepository : LoginRepository {

    override suspend fun login(password: String) : LoggedUserDomainModel {
        delay(1500)
        return LoggedUserDomainModel(
        id = "1",
        firstName = "Abdo",
        lastName = "mtl",
        state = true)
    }
}