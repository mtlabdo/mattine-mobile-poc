package com.mattine.mattinepoc.presentation.articleList.model

data class ArticlePresentationModel(
    val matricule: String,
    val nom: String? = null,
    val prixVente : Double? = null,
    val image: String? = null,
)