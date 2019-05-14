package com.example.sampleproject.pickdeatil

import com.example.sampleproject.data.CuratingContents
import com.example.sampleproject.data.PickChatMessage

interface PickListContract {

    interface View: BaseView {
        fun loadData(contents: ArrayList<CuratingContents>)
    }

    interface Presenter: BasePresenter<View> {
        fun getData()
    }

}