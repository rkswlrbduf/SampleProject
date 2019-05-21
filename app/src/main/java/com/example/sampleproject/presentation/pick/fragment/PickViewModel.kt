package com.example.sampleproject.presentation.pick.fragment

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.example.sampleproject.domain.CuratingContent
import com.example.sampleproject.presentation.pick.fragment.like.ContentsLikeDataSource
import com.example.sampleproject.presentation.pick.fragment.like.ContentsLikeDataSourceFactory
import com.example.sampleproject.presentation.pick.fragment.list.ContentsListDataSource
import com.example.sampleproject.presentation.pick.fragment.list.ContentsListDataSourceFactory
import javax.inject.Inject

class PickViewModel @Inject constructor(var contentsListDataSourceFactory: ContentsListDataSourceFactory, var contentsLikeDataSourceFactory: ContentsLikeDataSourceFactory) : ViewModel() {

    fun getPickList(): LiveData<PagedList<CuratingContent>> {
        var config = (PagedList.Config.Builder()).setEnablePlaceholders(false).setPageSize(ContentsListDataSource.PAGE_SIZE)
            .build()
        return LivePagedListBuilder(contentsListDataSourceFactory, config).build()
    }

    fun getPickLike(): LiveData<PagedList<CuratingContent>> {
        var config = (PagedList.Config.Builder()).setEnablePlaceholders(false).setPageSize(ContentsLikeDataSource.PAGE_SIZE)
            .build()
        return LivePagedListBuilder(contentsLikeDataSourceFactory, config).build()
    }

}