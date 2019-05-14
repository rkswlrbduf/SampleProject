package com.example.sampleproject.pickdeatil

import com.example.sampleproject.data.CuratingContents
import com.example.sampleproject.data.PickChatMessage

interface PickLikeContract {

    interface View: BaseView {

    }

    interface Presenter: BasePresenter<View> {
    }

}