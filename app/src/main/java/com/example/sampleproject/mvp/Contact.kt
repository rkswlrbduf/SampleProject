package com.example.sampleproject.mvp

import android.view.MotionEvent
import com.example.sampleproject.data.CuratingContents
import com.example.sampleproject.data.PickChatMessage

interface Contact {

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
        fun initView(view: View)
        fun endView()
        fun toggleLikeBtn()
        fun recvTouched(): Boolean
        fun loadData()
        fun loadRelatedContents()
    }

    // 1.
}