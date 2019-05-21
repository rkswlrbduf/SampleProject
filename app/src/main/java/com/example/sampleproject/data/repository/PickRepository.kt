package com.example.sampleproject.data.repository

import com.example.sampleproject.domain.CuratingContent
import com.example.sampleproject.domain.PagedCuratingContents
import io.reactivex.Single
import io.realm.Realm
import io.realm.RealmResults

interface PickRepository {

    fun getLikedContents(pageSize: Int, pageIndex: Int, realm: Realm): PagedCuratingContents
    fun getContents(pageSize: Int, pageIndex: Int, realm: Realm): PagedCuratingContents
    fun getDetailContents(): Single<CuratingContent>
    fun getRelatedContents(): Single<ArrayList<CuratingContent>>
    fun updateLike(realm: Realm, contentId: Int)
}