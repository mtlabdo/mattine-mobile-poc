package com.mattine.mattinepoc.presentation.architecture.viewmodel.coroutine

import com.mattine.mattinepoc.domain.cleanarchitecture.coroutine.CoroutineContextProvider
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class AppCoroutineContextProvider : CoroutineContextProvider {
    override val io = Dispatchers.IO
    override val main = Dispatchers.Main
}