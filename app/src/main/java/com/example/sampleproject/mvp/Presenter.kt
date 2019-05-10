package com.example.sampleproject.mvp

import android.util.Log
import com.example.sampleproject.data.PickRepositorylmpl
import com.example.sampleproject.data.CuratingContents
import io.reactivex.disposables.Disposable

class Presenter : Contact.Presenter {

    private var view: Contact.View? = null
    private val pickRepository: PickRepositorylmpl = PickRepositorylmpl()
    var contentsDisposable: Disposable? = null
    var RelatedDisposable: Disposable? = null
    private lateinit var contents: CuratingContents
    private lateinit var relatedContents: ArrayList<CuratingContents>
    var loadFinished = false


    override fun initView(view: Contact.View) {
        this.view = view
        view.init()
    }

    override fun endView() {
        this.view = null
        contentsDisposable?.dispose()
        RelatedDisposable?.dispose()
    }

    override fun toggleLikeBtn() {
        view?.runToggleLikeBtn()
    }

    override fun recvTouched(): Boolean {
        if (!loadFinished) {
            if (contents.messages.isNotEmpty()) {
                view?.runAddUserMessage(contents.messages[0])
                contents.messages.removeAt(0)
                view?.scrollToBottom()
            } else {
                view?.runAddMiddleMessage(message = "- 끝 -")
                view?.runRelatedMessage(relatedContents)
                view?.scrollToBottom()
                loadFinished = !loadFinished
            }
            return true
        }
        return false
    }

    override fun loadData() {
        contentsDisposable = pickRepository.getContents().subscribe({ contents ->
            this.contents = contents
            view?.runLoadData(contents)
            this.contents.messages.removeAt(0)

            loadRelatedContents()

        }, { e ->
            Log.d("TAG", e.message)
        })
    }

    override fun loadRelatedContents() {
        RelatedDisposable = pickRepository.getRelatedContents().subscribe({ relatedContents ->
            this.relatedContents = relatedContents
        }, { e ->
            Log.d("TAG", e.message)
        })
    }


}