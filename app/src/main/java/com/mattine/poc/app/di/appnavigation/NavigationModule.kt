package com.mattine.poc.app.di.appnavigation

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.mattine.mattinepoc.ui.articleList.mapper.ArticleDestinationToUiMapper
import com.mattine.mattinepoc.ui.login.mapper.LoginDestinationToUiMapper
import com.mattine.poc.app.navigation.AppArticleListDestinationToUiMapper
import com.mattine.poc.app.navigation.AppLoginDestinationToUiMapper
import com.mattine.poc.navigation.mapper.GlobalDestinationToUiMapper
import com.mattine.poc.ui.R
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class NavigationModule {

    @Provides
    fun providesSupportFragmentManager(activity: Activity) =
        (activity as AppCompatActivity).supportFragmentManager


    @Provides
    fun providesNavHostFragment(fragmentManager: FragmentManager) =
        fragmentManager.findFragmentById(R.id.main_fragment_container) as NavHostFragment


    @Provides
    fun providesNavController(navHostFragment: NavHostFragment) =
        navHostFragment.navController



    @Provides
    fun providesGlobalDestinationToUiMapper(
        lazyNavController: Lazy<NavController>
    ) = GlobalDestinationToUiMapper(lazyNavController)

    @Provides
    fun providesArticleListDestinationToUiMapper(
        globalDestinationToUiMapper: GlobalDestinationToUiMapper
    ): ArticleDestinationToUiMapper =
        AppArticleListDestinationToUiMapper(globalDestinationToUiMapper)

    @Provides
    fun providesLoginDestinationToUiMapper(
        fragmentManager: FragmentManager,
        globalDestinationToUiMapper: GlobalDestinationToUiMapper
    ): LoginDestinationToUiMapper = AppLoginDestinationToUiMapper(
        fragmentManager = fragmentManager,
        globalDestinationToUiMapper = globalDestinationToUiMapper
    )
}