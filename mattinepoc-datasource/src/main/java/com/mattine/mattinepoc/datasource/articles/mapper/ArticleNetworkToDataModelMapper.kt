package com.mattine.mattinepoc.datasource.articles.mapper

import com.mattine.mattinepoc.data.articles.model.ArticleDataModel
import com.mattine.mattinepoc.datasource.articles.model.ArticleNetworkModel

class ArticleNetworkToDataModelMapper {

    fun toData(input: ArticleNetworkModel) = ArticleDataModel(
        matricule = input.matricule,
        idCategory = input.idCategory,
        nom = input.nom,
        information = input.information,
        qteMax = input.qteMax,
        qteMin = input.qteMin,
        prixVente = input.prixVente,
        image = input.image,
        etat = input.etat,
    )
}