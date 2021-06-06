package com.kolumbo.popularlibrariesapp.presenter

import com.kolumbo.popularlibrariesapp.view.IItemView
import com.kolumbo.popularlibrariesapp.view.UserItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}

interface IUserListPresenter : IListPresenter<UserItemView>