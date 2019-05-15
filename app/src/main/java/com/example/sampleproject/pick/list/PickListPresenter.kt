package com.example.sampleproject.pickdeatil

import android.util.Log
import com.example.sampleproject.data.source.PickRepository
import com.example.sampleproject.data.source.RealmRepository
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.realm.Realm
import javax.inject.Inject

class PickListPresenter @Inject constructor(
    var pickRepository: PickRepository
) : PickListContract.Presenter {

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
        listDisposable = pickRepository.getContents().subscribe ({
            var realm = Realm.getDefaultInstance()
            realm.refresh()
            view?.loadData(it)
        }, {
            Log.e("TAG", it.localizedMessage)
        })
    }

}