package com.mattine.poc.app.di

import com.mattine.mattinepoc.domain.cleanarchitecture.coroutine.CoroutineContextProvider
import com.mattine.mattinepoc.domain.cleanarchitecture.usecase.UseCaseExecutor
import com.mattine.mattinepoc.presentation.architecture.viewmodel.coroutine.AppCoroutineContextProvider
import com.mattine.mattinepoc.presentation.architecture.viewmodel.usecase.UseCaseExecutorProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ArchitecturePresentationModule {

    @Provides
    fun providesCoroutineContextProvider(): CoroutineContextProvider = AppCoroutineContextProvider()

    @Provides
    fun providesUseCaseExecutor(): UseCaseExecutorProvider = ::UseCaseExecutor
}