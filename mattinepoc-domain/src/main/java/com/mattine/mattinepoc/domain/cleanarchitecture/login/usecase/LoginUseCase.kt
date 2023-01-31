package com.mattine.mattinepoc.domain.cleanarchitecture.login.usecase

import com.mattine.mattinepoc.domain.cleanarchitecture.coroutine.CoroutineContextProvider
import com.mattine.mattinepoc.domain.cleanarchitecture.login.model.LoggedUserDomainModel
import com.mattine.mattinepoc.domain.cleanarchitecture.login.repository.LoginRepository
import com.mattine.mattinepoc.domain.cleanarchitecture.usecase.BackgroundExecutingUseCase

class LoginUseCase(
    private val loginRepository: LoginRepository,
    coroutineContextProvider: CoroutineContextProvider
) :
    BackgroundExecutingUseCase<String, LoggedUserDomainModel>
        (coroutineContextProvider) {

    override suspend fun executeInBackground(request: String) = loginRepository.login(request)

}