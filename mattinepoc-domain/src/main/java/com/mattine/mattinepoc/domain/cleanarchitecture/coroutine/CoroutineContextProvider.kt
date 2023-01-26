package com.mattine.mattinepoc.domain.cleanarchitecture.coroutine

import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {
    val io : CoroutineContext
    val main : CoroutineContext
}