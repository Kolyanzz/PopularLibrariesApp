package com.kolumbo.popularlibrariesapp

class MainPresenter(val view: MainView) {
    val model = CountersModel()

    fun counterClick(btnCounterNumber: BtnCounterNumber) {
        when (btnCounterNumber) {
            BtnCounterNumber.ONE -> {
                val nextValue = model.next(0)
                view.setButton1Text("$nextValue")
            }
            BtnCounterNumber.TWO -> {
                val nextValue = model.next(1)
                view.setButton2Text("$nextValue")
            }
            BtnCounterNumber.THREE -> {
                val nextValue = model.next(2)
                view.setButton3Text("$nextValue")
            }
        }
    }
}