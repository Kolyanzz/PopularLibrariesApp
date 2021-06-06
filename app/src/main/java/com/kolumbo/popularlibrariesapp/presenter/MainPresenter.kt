package com.kolumbo.popularlibrariesapp.presenter

import com.github.terrakok.cicerone.Router
import com.kolumbo.popularlibrariesapp.navigation.IScreens
import com.kolumbo.popularlibrariesapp.view.MainView
import moxy.MvpPresenter

class MainPresenter(val router: Router, val screens: IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }
}