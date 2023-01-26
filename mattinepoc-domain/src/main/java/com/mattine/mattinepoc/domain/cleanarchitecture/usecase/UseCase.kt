package com.mattine.mattinepoc.domain.cleanarchitecture.usecase

interface UseCase<REQUEST, RESULT> {

    suspend fun execute(input: REQUEST, onResult : (RESULT) -> Unit)
}