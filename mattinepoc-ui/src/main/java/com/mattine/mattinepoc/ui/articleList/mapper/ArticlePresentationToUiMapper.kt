package com.mattine.mattinepoc.ui.articleList.mapper

import com.mattine.mattinepoc.presentation.articleList.model.ArticlePresentationModel
import com.mattine.mattinepoc.ui.articleList.model.ArticleUiModel

class ArticlePresentationToUiMapper {

    fun toUi(article: ArticlePresentationModel) = ArticleUiModel(
        matricule = article.matricule,
        name = article.nom,
        image = article.image,
        price = article.prixVente
    )
}