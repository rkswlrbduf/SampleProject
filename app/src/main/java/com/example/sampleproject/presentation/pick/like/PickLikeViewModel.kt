package com.example.sampleproject.presentation.pick.like

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import com.example.sampleproject.domain.CuratingContents
import com.example.sampleproject.presentation.pick.PickActivity
import com.example.sampleproject.presentation.pick.PickRecylcerAdapter
import com.example.sampleproject.presentation.pickdeatil.PickDetailActivity
import com.example.sampleproject.presentation.pickdeatil.PickDetailContact
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import io.realm.RealmChangeListener
import io.realm.RealmResults
import kotlinx.android.synthetic.main.fragment_like.*
import javax.inject.Inject

class PickLikeViewModel @Inject constructor(var pickRepository: PickRepositoryImpl) : ViewModel() {

    var likeLiveData = MutableLiveData<RealmResults<CuratingContents>>()
    private var realmResultList: RealmResults<CuratingContents>? = null

    init {
        realmResultList = pickRepository.getLikedContents()
        likeLiveData.value = realmResultList
        realmResultList?.addChangeListener { t ->
            likeLiveData.value = t
        }
    }

}