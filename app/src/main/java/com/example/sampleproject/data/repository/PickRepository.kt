package com.example.sampleproject.data.repository

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.example.sampleproject.domain.CuratingContents
import io.reactivex.Observable
import io.reactivex.Single
import io.realm.RealmChangeListener
import io.realm.RealmResults
import io.realm.rx.CollectionChange

interface PickRepository {

    fun getLikedContents(): LiveData<PagedList<CuratingContents>>
    fun getContents(): LiveData<PagedList<CuratingContents>>
    fun getDetailContents(): Single<CuratingContents>
    fun getRelatedContents(): Single<ArrayList<CuratingContents>>
    fun updateLike(contentId: Int)
}