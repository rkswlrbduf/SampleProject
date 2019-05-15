package com.example.sampleproject.data.source

import com.example.sampleproject.data.CuratingContents
import io.reactivex.Observable

interface RealmDataSource {

    fun isEmptyLocalDB(): Boolean
    fun getLocalDB(): Observable<CuratingContents>

}