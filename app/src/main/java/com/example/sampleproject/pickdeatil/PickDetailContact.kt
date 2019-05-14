package com.example.sampleproject.pickdeatil

import com.example.sampleproject.data.CuratingContents
import com.example.sampleproject.data.PickChatMessage

interface PickDetailContact {

    interface View: BaseView {
        fun scrollToBottom()
        fun runToggleLikeBtn()
        fun runLoadData(contents: CuratingContents)
        fun runAddUserMessage(message: PickChatMessage)
        fun runAddMiddleMessage(message: String)
        fun runRelatedMessage(lists: ArrayList<CuratingContents>)
    }

    interface Presenter: BasePresenter<View> {
        fun toggleLikeBtn()
        fun recvTouched(): Boolean
        fun loadData()
        fun loadRelatedContents()
    }

}