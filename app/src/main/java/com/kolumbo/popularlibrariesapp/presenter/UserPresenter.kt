package com.kolumbo.popularlibrariesapp.presenter

import com.github.terrakok.cicerone.Router
import com.kolumbo.popularlibrariesapp.model.GithubUser
import com.kolumbo.popularlibrariesapp.view.UserView
import moxy.MvpPresenter

class UserPresenter(val user: GithubUser, val router: Router) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showUser(user.login)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}