package com.example.sampleproject.presentation.pickdeatil

interface BaseView {
    fun init()
}

interface BasePresenter<T> {
    fun attachView(view: T)
    fun detachView()
}
