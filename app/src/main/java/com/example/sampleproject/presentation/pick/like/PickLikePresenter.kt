package com.example.sampleproject.presentation.pickdeatil

import android.util.Log
import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class PickLikePresenter @Inject constructor(var pickRepository: PickRepositoryImpl) :
    PickLikeContract.Presenter {

    private var view: PickLikeContract.View? = null
    var contentsDisposable: Disposable? = null
    var relatedDisposable: Disposable? = null

    override fun attachView(view: PickLikeContract.View) {
        this.view = view
        view.init()
    }

    override fun getLikedContents() {
        pickRepository.getLikedContents().subscribe ({
            view?.loadLikedContents(it)
        }, {
            Log.e("TAG", it.localizedMessage)
        })
    }

    override fun detachView() {
        this.view = null
        contentsDisposable?.dispose()
        relatedDisposable?.dispose()
    }

}