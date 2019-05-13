package com.example.sampleproject.data.source

import com.example.sampleproject.data.CuratingContents
import io.reactivex.Single

interface PickDataSource {

    fun getContents(): Single<CuratingContents>
    fun getRelatedContents(): Single<ArrayList<CuratingContents>>

}