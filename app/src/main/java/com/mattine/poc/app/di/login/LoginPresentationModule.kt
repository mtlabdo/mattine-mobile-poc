package com.mattine.poc.app.di.login

import com.mattine.mattinepoc.domain.cleanarchitecture.coroutine.CoroutineContextProvider
import com.mattine.mattinepoc.domain.cleanarchitecture.login.repository.LoginRepository
import com.mattine.mattinepoc.domain.cleanarchitecture.login.usecase.LoginUseCase
import com.mattine.mattinepoc.presentation.login.mapper.LoggedUserDomainToPresentationMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class LoginPresentationModule {

    @Provides
    fun providesLoginUseCase(
        loginRepository: LoginRepository, coroutineContextProvider: CoroutineContextProvider
    ) = LoginUseCase(loginRepository, coroutineContextProvider)

    @Provides
    fun providesLoggedUserDomainToPresentationMapper() = LoggedUserDomainToPresentationMapper()
}