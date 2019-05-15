package com.example.sampleproject.pickdeatil

import com.example.sampleproject.data.CuratingContents
import com.example.sampleproject.data.PickChatMessage
import io.realm.RealmResults

interface PickListContract {

    interface View: BaseView {
        fun loadData(contents: CuratingContents)
    }

    interface Presenter: BasePresenter<View> {
        fun getData()
    }

}