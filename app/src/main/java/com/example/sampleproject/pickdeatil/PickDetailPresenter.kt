package com.example.sampleproject.pickdeatil

import android.util.Log
import com.example.sampleproject.data.CuratingContents
import com.example.sampleproject.data.source.PickRepository
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class PickDetailPresenter @Inject constructor(
    var pickRepository: PickRepository
) : PickDetailContact.Presenter {

    private var view: PickDetailContact.View? = null
    var contentsDisposable: Disposable? = null
    var relatedDisposable: Disposable? = null
    private lateinit var contents: CuratingContents
    private lateinit var relatedContents: ArrayList<CuratingContents>
    var loadFinished = false

    override fun attachView(view: PickDetailContact.View) {
        this.view = view
        view.init()
    }

    override fun detachView() {
        this.view = null
        contentsDisposable?.dispose()
        relatedDisposable?.dispose()
    }

    override fun toggleLikeBtn() {
        view?.runToggleLikeBtn()
    }

    override fun recvTouched(): Boolean {
        Log.d("TAG", "CLICKEDDDD")
        if (!loadFinished) {
            if (contents.messages.isNotEmpty()) {
                view?.runAddUserMessage(contents.messages[0]!!)
                contents.messages.removeAt(0)
            } else {
                view?.runAddMiddleMessage(message = "- 끝 -")
                view?.runRelatedMessage(relatedContents)
                loadFinished = !loadFinished
            }
            view?.scrollToBottom()
            return true
        }
        return false
    }

    override fun loadData() {
        contentsDisposable = pickRepository.getDetailContents().subscribe({ contents ->
            this.contents = contents
            view?.runLoadData(contents)
            this.contents.messages.removeAt(0)

            loadRelatedContents()

        }, { e ->
            Log.d("TAG", e.message)
        })
    }

    override fun loadRelatedContents() {
        relatedDisposable = pickRepository.getRelatedContents().subscribe({ relatedContents ->
            this.relatedContents = relatedContents
        }, { e ->
            Log.d("TAG", e.message)
        })
    }


}