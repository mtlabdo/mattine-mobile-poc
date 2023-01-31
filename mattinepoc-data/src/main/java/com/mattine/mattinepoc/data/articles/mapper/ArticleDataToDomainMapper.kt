package com.mattine.mattinepoc.data.articles.mapper

import com.mattine.mattinepoc.data.articles.model.ArticleDataModel
import com.mattine.mattinepoc.domain.cleanarchitecture.articles.model.ArticleDomainModel

class ArticleDataToDomainMapper {

    fun toDomain(input: ArticleDataModel) = ArticleDomainModel(
        matricule = input.matricule,
        idCategory = input.idCategory,
        nom = input.nom,
        information = input.information,
        qteMax = input.qteMax,
        qteMin = input.qteMin,
        prixVente = input.prixVente,
        image = input.image.toString(),
        etat = input.etat,
    )
}