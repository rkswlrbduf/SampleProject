package com.example.sampleproject.data.source

import com.example.sampleproject.data.CuratingContents
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface PickDataSource {

    fun getContents(): Observable<CuratingContents>
    fun getDetailContents(): Single<CuratingContents>
    fun getRelatedContents(): Single<ArrayList<CuratingContents>>

}