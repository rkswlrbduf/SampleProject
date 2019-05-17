package com.example.sampleproject.presentation.pick

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import com.example.sampleproject.domain.CuratingContents
import com.example.sampleproject.presentation.pickdeatil.PickDetailContact
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import io.realm.RealmChangeListener
import io.realm.RealmResults
import javax.inject.Inject

class PickViewModel @Inject constructor(
    var pickRepository: PickRepositoryImpl, var realm: Realm
) : ViewModel() {

    var likedContents = MutableLiveData<ArrayList<CuratingContents>>()
    private var realmResultList: RealmResults<CuratingContents>? = null

    init {
        loadLikedData()
    }

    private fun loadLikedData() {
        realmResultList = pickRepository.getLikedContents()
        realmResultList?.addChangeListener { t ->
            likedContents.value = ArrayList(t)
        }
    }
}