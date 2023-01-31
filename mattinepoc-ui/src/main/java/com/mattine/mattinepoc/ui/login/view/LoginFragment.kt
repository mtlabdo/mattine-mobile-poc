package com.mattine.mattinepoc.ui.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.mattine.mattinepoc.presentation.login.model.LoginPresentationNotification
import com.mattine.mattinepoc.presentation.login.model.LoginViewState
import com.mattine.mattinepoc.presentation.login.viewModel.LoginViewModel
import com.mattine.mattinepoc.ui.architecture.mapper.ViewStateBinder
import com.mattine.mattinepoc.ui.architecture.view.BaseFragment
import com.mattine.mattinepoc.ui.architecture.view.ViewsProvider
import com.mattine.mattinepoc.ui.login.mapper.LoginNotificationPresentationToUiMapper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import androidx.fragment.app.viewModels
import com.mattine.mattinepoc.ui.login.mapper.LoginDestinationToUiMapper
import com.mattine.poc.ui.R

@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginViewState, LoginPresentationNotification>(),
    LoginViewsProvider {

    override val viewModel: LoginViewModel by viewModels()

    @Inject
    override lateinit var destinationMapper: LoginDestinationToUiMapper

    @Inject
    override lateinit var notificationMapper: LoginNotificationPresentationToUiMapper

    @Inject
    @JvmSuppressWildcards
    override lateinit var viewStateBinder: ViewStateBinder<LoginViewState, ViewsProvider>

    override val layoutResourceId = R.layout.layout_login

    override lateinit var passwordField: TextView

    override lateinit var submitLoginButton: View


    override fun View.bindViews() {
        passwordField = findViewById(R.id.passwordField)
        submitLoginButton = findViewById(R.id.submitLogin)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        submitLoginButton.setOnClickListener {
            val password = passwordField.text.toString()
            viewModel.onLogin(password)
        }
        return view
    }

    companion object {

        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

}