package com.example.sampleproject.presentation.pickdeatil

import com.example.sampleproject.domain.CuratingContents

interface PickListContract {

    interface View: BaseView {
        fun loadData(contents: CuratingContents)
    }

    interface Presenter: BasePresenter<View> {
        fun getData()
    }

}