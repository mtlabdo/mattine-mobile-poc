package com.mattine.poc.app.di.login

import com.mattine.mattinepoc.domain.cleanarchitecture.login.repository.LoginDummyRepository
import com.mattine.mattinepoc.domain.cleanarchitecture.login.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LoginDataModule {

    @Provides
    fun providesLoginRepository() : LoginRepository = LoginDummyRepository()
}