package com.mattine.mattinepoc.domain.cleanarchitecture.login.model

data class LoggedUserDomainModel(
    val id: String,
    val firstName: String?,
    val lastName: String?,
    val state: Boolean,
)