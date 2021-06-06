package com.kolumbo.popularlibrariesapp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface UserView : MvpView {
    fun showUser(login: String)
}