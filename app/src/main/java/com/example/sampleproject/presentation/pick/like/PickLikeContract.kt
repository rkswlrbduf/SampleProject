package com.example.sampleproject.presentation.pickdeatil

import com.example.sampleproject.domain.CuratingContents

interface PickLikeContract {

    interface View: BaseView {
        fun loadLikedContents(contents: CuratingContents)
    }

    interface Presenter: BasePresenter<View> {
        fun getLikedContents()
    }

}