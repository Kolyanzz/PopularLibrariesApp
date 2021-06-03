package com.kolumbo.popularlibrariesapp.model

class GithubUsersRepo {
    private val repositories = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5"),
        GithubUser("login6"),
        GithubUser("login7")
    )

    fun getUsers(): List<GithubUser> {
        return repositories
    }
}