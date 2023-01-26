package com.mattine.mattinepoc.domain.cleanarchitecture.articles.model

data class ArticleDomainModel(
    val matricule: String,
    val idCategory: Int,
    val nom: String? = null,
    val information: String? = null,
    val qteMax: Double? = null,
    val qteMin: Double? = null,
    val prixVente: Double? = null,
    val image: String? = null,
    val etat: Boolean? = false,
)