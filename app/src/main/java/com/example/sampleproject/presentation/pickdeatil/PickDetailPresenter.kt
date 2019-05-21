package com.example.sampleproject.presentation.pickdeatil

import android.util.Log
import com.example.sampleproject.domain.CuratingContent
import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import io.reactivex.disposables.Disposable
import io.realm.Realm
import javax.inject.Inject

class PickDetailPresenter @Inject constructor(
    var pickRepository: PickRepositoryImpl
) : PickDetailContact.Presenter {

    private var view: PickDetailContact.View? = null
    var contentsDisposable: Disposable? = null
    var relatedDisposable: Disposable? = null
    private lateinit var contents: CuratingContent
    private lateinit var relatedContents: ArrayList<CuratingContent>
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

    override fun updateLike(id: Int) {
        pickRepository.updateLike(Realm.getDefaultInstance(), id)
    }

}