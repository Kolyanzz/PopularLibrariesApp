package com.kolumbo.popularlibrariesapp.navigation

import com.github.terrakok.cicerone.Screen
import com.kolumbo.popularlibrariesapp.model.GithubUser

interface IScreens {
    fun users(): Screen
    fun user(user: GithubUser): Screen
}