package com.mattine.mattinepoc.presentation.architecture.viewmodel.usecase

import com.mattine.mattinepoc.domain.cleanarchitecture.usecase.UseCaseExecutor
import kotlinx.coroutines.CoroutineScope

typealias UseCaseExecutorProvider = @JvmSuppressWildcards (coroutineScope : CoroutineScope) -> UseCaseExecutor