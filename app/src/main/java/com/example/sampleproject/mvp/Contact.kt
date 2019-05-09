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
    }

    interface Presenter {
        fun initView(view: View)
        fun toggleLikeBtn()
        fun recvTouched(e: MotionEvent): Boolean
        fun loadData(json: String)
    }

}