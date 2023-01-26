package com.mattine.mattinepoc.presentation.articleList.mapper

import com.mattine.mattinepoc.domain.cleanarchitecture.articles.model.ArticleDomainModel
import com.mattine.mattinepoc.presentation.articleList.model.ArticlePresentationModel

class ArticleDomainToPresentationMapper {

    fun toPresentation(input: ArticleDomainModel) = ArticlePresentationModel(
        matricule = input.matricule,
        nom = input.nom,
        image = input.image,
        prixVente = input.prixVente,
    )
}