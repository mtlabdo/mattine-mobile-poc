package com.mattine.mattinepoc.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.mattine.mattinepoc.ui.articleList.view.ArticleListFragment
import com.mattine.mattinepoc.ui.login.view.LoginFragment
import com.mattine.poc.ui.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            add(R.id.main_fragment_container, LoginFragment.newInstance())
        }
    }
}