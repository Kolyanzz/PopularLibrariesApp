package com.kolumbo.popularlibrariesapp.view

interface IItemView {
    var pos: Int
}

interface UserItemView : IItemView {
    fun setLogin(text: String)
}