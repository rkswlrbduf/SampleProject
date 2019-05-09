package com.example.sampleproject.mvp

import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import com.example.sampleproject.PickRepositorylmpl
import com.example.sampleproject.data.CuratingContents
import io.reactivex.disposables.Disposable

class Presenter : Contact.Presenter {

    private lateinit var view: Contact.View
    private val pickRepository: PickRepositorylmpl = PickRepositorylmpl()
    var disposable: Disposable? = null
    private lateinit var contents: CuratingContents
    var loadFinished = false

    override fun initView(view: Contact.View) {
        this.view = view
        view.init()
    }

    override fun toggleLikeBtn() {
        view.runToggleLikeBtn()
    }

    override fun recvTouched(e: MotionEvent): Boolean {
        if (e.action == MotionEvent.ACTION_UP && !loadFinished) {
            if (contents.messages.isNotEmpty()) {
                view.runAddUserMessage(contents.messages[0])
                contents.messages.removeAt(0)
            } else {
                view.runAddMiddleMessage(message = "- 끝 -")
                loadFinished = !loadFinished
            }
            view.scrollToBottom()
            return true
        }
        return false
    }

    override fun loadData(json: String) {
        disposable = pickRepository.getContents(json).subscribe({ contents ->
            this.contents = contents
            view.runLoadData(contents)
            this.contents.messages.removeAt(0)
        }, { e ->
            Log.d("TAG", e.message)
        })
    }

}