package com.example.sampleproject.data.source

import android.util.Log
import com.example.sampleproject.data.CuratingContents
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.Module
import dagger.Provides
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import io.realm.RealmList
import javax.inject.Inject
import android.R.attr.resource
import android.arch.lifecycle.LiveData
import io.realm.Realm
import io.realm.Realm.setDefaultConfiguration
import io.realm.RealmConfiguration
import io.realm.RealmResults

class RealmRepository @Inject constructor(var realm: Realm) : RealmDataSource {

    override fun isEmptyLocalDB(): Boolean {
        return realm.where(CuratingContents::class.java).findAll().isEmpty()
    }

    override fun getLocalDB(): Observable<CuratingContents> {
        val lists = realm.where(CuratingContents::class.java).findAll().toObservable()
        return lists.subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
    }

}