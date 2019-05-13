package com.example.sampleproject

import com.example.sampleproject.data.CuratingContents
import com.example.sampleproject.data.PickChatMessage

interface PickContact {

    interface View {
        fun init()
        fun scrollToBottom()
        fun runToggleLikeBtn()
        fun runLoadData(contents: CuratingContents)
        fun runAddUserMessage(message: PickChatMessage)
        fun runAddMiddleMessage(message: String)
        fun runRelatedMessage(lists: ArrayList<CuratingContents>)
    }

    interface Presenter {
        fun attachView(view: View)
        fun detachView()
        fun toggleLikeBtn()
        fun recvTouched(): Boolean
        fun loadData()
        fun loadRelatedContents()
    }

    // 1.
}