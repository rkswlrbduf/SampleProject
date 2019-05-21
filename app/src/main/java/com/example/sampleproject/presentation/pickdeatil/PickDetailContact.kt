package com.example.sampleproject.presentation.pickdeatil

import com.example.sampleproject.domain.CuratingContent
import com.example.sampleproject.domain.PickChatMessage

interface PickDetailContact {

    interface View: BaseView {
        fun scrollToBottom()
        fun runToggleLikeBtn()
        fun runLoadData(contents: CuratingContent)
        fun runAddUserMessage(message: PickChatMessage)
        fun runAddMiddleMessage(message: String)
        fun runRelatedMessage(lists: ArrayList<CuratingContent>)
    }

    interface Presenter: BasePresenter<View> {
        fun updateLike(id: Int)
        fun toggleLikeBtn()
        fun recvTouched(): Boolean
        fun loadData()
        fun loadRelatedContents()
    }

}