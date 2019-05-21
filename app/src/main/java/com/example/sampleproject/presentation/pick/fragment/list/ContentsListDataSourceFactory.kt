package com.example.sampleproject.presentation.pick.fragment.list

import android.arch.paging.DataSource
import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import com.example.sampleproject.domain.CuratingContent
import io.realm.Realm
import javax.inject.Inject


class ContentsListDataSourceFactory @Inject constructor(var contentsListDataSource: ContentsListDataSource): DataSource.Factory<Int, CuratingContent>() {

    override fun create(): DataSource<Int, CuratingContent> {
        return contentsListDataSource
    }

}