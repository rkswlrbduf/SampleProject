package com.example.sampleproject.data.repository

import android.arch.lifecycle.LiveData
import com.example.sampleproject.domain.CuratingContents
import io.reactivex.Observable
import io.reactivex.Single
import io.realm.RealmChangeListener
import io.realm.RealmResults
import io.realm.rx.CollectionChange

interface PickRepository {

    fun getLikedContents(): RealmResults<CuratingContents>
    fun getContents(): Observable<CuratingContents>
    fun getDetailContents(): Single<CuratingContents>
    fun getRelatedContents(): Single<ArrayList<CuratingContents>>
    fun updateLike(contentId: Int)
}