package com.example.sampleproject.presentation.pickdeatil

import android.util.Log
import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class PickListPresenter @Inject constructor(var pickRepository: PickRepositoryImpl) : PickListContract.Presenter {

    private var view: PickListContract.View? = null
    var listDisposable: Disposable? = null

    override fun attachView(view: PickListContract.View) {
        this.view = view
        view.init()
    }

    override fun detachView() {
        this.view = null
        listDisposable?.dispose()
    }

    override fun getData() {
        listDisposable = pickRepository.getContents().subscribe({
            view?.loadData(it)
        }, {
            Log.e("TAG", it.localizedMessage)
        })
    }

}