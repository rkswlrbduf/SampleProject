package com.example.sampleproject.presentation.pick.fragment.like

import android.arch.paging.DataSource
import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import com.example.sampleproject.domain.CuratingContent
import io.realm.Realm
import javax.inject.Inject


class ContentsLikeDataSourceFactory @Inject constructor(var contentsLikeDataSource: ContentsLikeDataSource): DataSource.Factory<Int, CuratingContent>() {

    override fun create(): DataSource<Int, CuratingContent> {
        return contentsLikeDataSource
    }

}