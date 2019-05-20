package com.example.sampleproject.presentation.pick.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import com.example.sampleproject.domain.CuratingContents
import io.realm.RealmResults
import javax.inject.Inject

class PickListViewModel @Inject constructor(pickRepository: PickRepositoryImpl): ViewModel() {


    var listLiveData = MutableLiveData<RealmResults<CuratingContents>>()
    private var realmResultList: RealmResults<CuratingContents>? = null

    init {
        realmResultList = pickRepository.getContents()
        listLiveData.value = realmResultList
        realmResultList?.addChangeListener { t ->
            listLiveData.value = t
        }
    }

}