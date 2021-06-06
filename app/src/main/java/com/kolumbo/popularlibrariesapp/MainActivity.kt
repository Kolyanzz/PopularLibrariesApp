package com.kolumbo.popularlibrariesapp

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.kolumbo.popularlibrariesapp.databinding.ActivityMainBinding
import com.kolumbo.popularlibrariesapp.navigation.AndroidScreens
import com.kolumbo.popularlibrariesapp.navigation.BackButtonListener
import com.kolumbo.popularlibrariesapp.presenter.MainPresenter
import com.kolumbo.popularlibrariesapp.view.MainView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    val navigator = AppNavigator(this, R.id.container)
    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter { MainPresenter(App.instance.router, AndroidScreens()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
    }
}
