package com.mattine.poc.app.di.articles

import com.mattine.mattinepoc.data.articles.datasource.ArticleListDataSource
import com.mattine.mattinepoc.datasource.articles.datasource.ArticleListLiveDataSource
import com.mattine.mattinepoc.datasource.articles.mapper.ArticleNetworkToDataModelMapper
import com.mattine.mattinepoc.datasource.articles.network.ArticleApi
import com.mattine.mattinepoc.datasource.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ArticleListDataSourceModule {

    @Provides
    fun providesArticleNetworkToDataModelMapper(): ArticleNetworkToDataModelMapper =
        ArticleNetworkToDataModelMapper()


    @Provides
    fun providesArticleApi(apiService: ApiService): ArticleApi =
        apiService.getApiService<ArticleApi>()

    @Provides
    @Singleton
    fun providesArticleListLiveDataSource(
        articleNetworkToDataModelMapper: ArticleNetworkToDataModelMapper,
        articleApi: ArticleApi
    ): ArticleListDataSource =
        ArticleListLiveDataSource(articleNetworkToDataModelMapper, articleApi)


}