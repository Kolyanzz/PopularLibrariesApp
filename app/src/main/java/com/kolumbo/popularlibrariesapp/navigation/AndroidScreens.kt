package com.kolumbo.popularlibrariesapp.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.kolumbo.popularlibrariesapp.UserFragment
import com.kolumbo.popularlibrariesapp.UsersFragment
import com.kolumbo.popularlibrariesapp.model.GithubUser

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }

    override fun user(user: GithubUser) = FragmentScreen { UserFragment.newInstance(user) }
}