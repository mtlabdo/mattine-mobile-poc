package com.mattine.poc.app.navigation

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.mattine.mattinepoc.presentation.architecture.mdoel.PresentationDestination
import com.mattine.mattinepoc.presentation.login.destination.LoginPresentationDestination
import com.mattine.mattinepoc.presentation.login.model.LoggedUserPresentationModel
import com.mattine.mattinepoc.ui.architecture.view.BottomDialogFragment
import com.mattine.mattinepoc.ui.articleList.view.ArticleListFragment
import com.mattine.mattinepoc.ui.login.mapper.LoginDestinationToUiMapper.LoginSuccessUiDestination
import com.mattine.mattinepoc.ui.navigation.model.UiDestination
import com.mattine.mattinepoc.ui.login.mapper.LoginDestinationToUiMapper
import com.mattine.poc.navigation.mapper.GlobalDestinationToUiMapper
import com.mattine.poc.ui.R

class AppLoginDestinationToUiMapper(
    private val fragmentManager: FragmentManager,
    private val globalDestinationToUiMapper: GlobalDestinationToUiMapper
) : LoginDestinationToUiMapper {

    override fun toUi(input: PresentationDestination): UiDestination = when (input) {
        is LoginPresentationDestination.UserLoginSuccess -> {
            ArticleList(fragmentManager, input.loggedUser)
        }
        else -> globalDestinationToUiMapper.toUi(input)
    }

    data class ArticleList(
        val fragmentManager: FragmentManager,
        val loggedUserPresentationModel: LoggedUserPresentationModel
    ) : LoginSuccessUiDestination(loggedUserPresentationModel) {
        override fun navigate() {
            val articlesFragment = ArticleListFragment.newInstance(1)
            BottomDialogFragment(articlesFragment)
                .show(fragmentManager, "ArticleList")
        }

    }
}