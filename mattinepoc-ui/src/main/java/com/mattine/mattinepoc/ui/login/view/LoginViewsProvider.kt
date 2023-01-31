package com.mattine.mattinepoc.ui.login.view

import android.view.View
import android.widget.TextView
import com.mattine.mattinepoc.ui.architecture.view.ViewsProvider

interface LoginViewsProvider : ViewsProvider {
    val passwordField: TextView
    val submitLoginButton: View
}