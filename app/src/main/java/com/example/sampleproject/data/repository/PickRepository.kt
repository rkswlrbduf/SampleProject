package com.example.sampleproject.data.repository

import com.example.sampleproject.domain.CuratingContents
import io.reactivex.Observable
import io.reactivex.Single

interface PickRepository {

    fun getLikedContents(): Observable<CuratingContents>
    fun getContents(): Observable<CuratingContents>
    fun getDetailContents(): Single<CuratingContents>
    fun getRelatedContents(): Single<ArrayList<CuratingContents>>
    fun updateLike(contentId: Int)

}