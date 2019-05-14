package com.example.sampleproject.pickdeatil

import com.example.sampleproject.data.CuratingContents
import com.example.sampleproject.data.PickChatMessage

interface BaseView {
    fun init()
}

interface BasePresenter<T> {
    fun attachView(view: T)
    fun detachView()
}
