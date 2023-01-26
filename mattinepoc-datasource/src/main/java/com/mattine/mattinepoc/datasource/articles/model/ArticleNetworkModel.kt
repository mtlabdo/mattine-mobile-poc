package com.mattine.mattinepoc.datasource.articles.model

import com.google.gson.annotations.SerializedName

data class ArticleNetworkModel(

    @SerializedName("Matricule")
    val matricule: String,

    @SerializedName("IdCategory")
    val idCategory: Int,

    @SerializedName("Nom")
    val nom: String?,

    @SerializedName("Information")
    val information: String?,

    @SerializedName("QteMax")
    val qteMax: Double?,

    @SerializedName("QteMin")
    val qteMin: Double?,

    @SerializedName("PrixVente")
    val prixVente: Double?,

    @SerializedName("Image")
    val image: String?,

    @SerializedName("Etat")
    val etat: Boolean?,

    )