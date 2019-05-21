package com.example.sampleproject.presentation.pick.fragment

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import com.example.sampleproject.domain.CuratingContent
import com.example.sampleproject.presentation.pick.fragment.list.ContentsListDataSource
import com.example.sampleproject.presentation.pick.fragment.list.ContentsListDataSourceFactory
import io.realm.RealmResults
import javax.inject.Inject

class PickViewModel @Inject constructor(
    var pickRepositoryImpl: PickRepositoryImpl,
    var contentsListDataSourceFactory: ContentsListDataSourceFactory
) : ViewModel() {

    var likeLiveData = MutableLiveData<RealmResults<CuratingContent>>()
    private var realmResultList: RealmResults<CuratingContent>? = null

    fun getPickList(): LiveData<PagedList<CuratingContent>> {
        var config =
            (PagedList.Config.Builder()).setEnablePlaceholders(false).setPageSize(ContentsListDataSource.PAGE_SIZE)
                .build()
        return LivePagedListBuilder(contentsListDataSourceFactory, config).build()
    }

    fun getPickLike() {
        realmResultList = pickRepositoryImpl.getLikedContents()
        likeLiveData.value = realmResultList
        realmResultList?.addChangeListener { t ->
            likeLiveData.value = t
        }
    }

}