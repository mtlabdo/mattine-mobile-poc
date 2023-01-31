package com.mattine.mattinepoc.data.articles.model

data class ArticleDataModel(
    val matricule: String,
    val idCategory: Int,
    val nom: String?,
    val information: String?,
    val qteMax: Double?,
    val qteMin: Double?,
    val prixVente: Double?,
    val image: Any?,
    val etat: Boolean?,
)