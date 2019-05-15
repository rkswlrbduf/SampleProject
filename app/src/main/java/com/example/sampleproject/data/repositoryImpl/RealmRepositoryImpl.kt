package com.example.sampleproject.data.repositoryImpl

import com.example.sampleproject.domain.CuratingContents
import com.example.sampleproject.data.repository.RealmRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import io.realm.Realm

class RealmRepositoryImpl @Inject constructor(var realm: Realm) :
    RealmRepository {

    override fun isEmptyLocalDB(): Boolean {
        return realm.where(CuratingContents::class.java).findAll().isEmpty()
    }

    override fun getLocalDB(): Observable<CuratingContents> {
        val lists = realm.where(CuratingContents::class.java).findAll().toObservable()
        return lists.subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
    }

}