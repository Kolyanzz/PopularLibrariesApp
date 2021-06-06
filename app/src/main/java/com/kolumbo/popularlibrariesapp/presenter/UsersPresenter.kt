package com.kolumbo.popularlibrariesapp.presenter

import com.github.terrakok.cicerone.Router
import com.kolumbo.popularlibrariesapp.model.GithubUser
import com.kolumbo.popularlibrariesapp.model.GithubUsersRepo
import com.kolumbo.popularlibrariesapp.navigation.AndroidScreens
import com.kolumbo.popularlibrariesapp.view.UserItemView
import com.kolumbo.popularlibrariesapp.view.UsersView
import moxy.MvpPresenter

class UsersPresenter(val usersRepo: GithubUsersRepo, val router: Router) :
    MvpPresenter<UsersView>() {

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }

        override fun getCount() = users.size
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { itemView ->
            val currentUser = usersListPresenter.users[itemView.pos]
            router.navigateTo(AndroidScreens().user(currentUser))
        }
    }

    fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}