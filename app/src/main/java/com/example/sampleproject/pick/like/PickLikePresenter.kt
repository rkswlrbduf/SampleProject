package com.example.sampleproject.pickdeatil

import com.example.sampleproject.data.source.PickRepository
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class PickLikePresenter @Inject constructor(var pickRepository: PickRepository) :
    PickLikeContract.Presenter {

    private var view: PickLikeContract.View? = null
    var contentsDisposable: Disposable? = null
    var relatedDisposable: Disposable? = null

    override fun attachView(view: PickLikeContract.View) {
        this.view = view
        view.init()
    }

    override fun detachView() {
        this.view = null
        contentsDisposable?.dispose()
        relatedDisposable?.dispose()
    }

}