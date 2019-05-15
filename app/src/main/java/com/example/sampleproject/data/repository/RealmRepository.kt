package com.example.sampleproject.data.repository

import com.example.sampleproject.domain.CuratingContents
import io.reactivex.Observable

interface RealmRepository {

    fun isEmptyLocalDB(): Boolean
    fun getLocalDB(): Observable<CuratingContents>

}