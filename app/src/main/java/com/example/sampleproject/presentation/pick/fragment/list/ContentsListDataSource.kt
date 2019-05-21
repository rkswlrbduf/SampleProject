package com.example.sampleproject.presentation.pick.fragment.list

import android.arch.paging.PageKeyedDataSource
import android.util.Log
import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import com.example.sampleproject.domain.CuratingContent
import io.realm.Realm
import javax.inject.Inject

class ContentsListDataSource @Inject constructor(var pickRepository: PickRepositoryImpl) :
    PageKeyedDataSource<Int, CuratingContent>() {

    companion object {
        var PAGE_SIZE = 10
        var PAGE_INDEX = 1
    }

    init {
        PAGE_INDEX = 1
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, CuratingContent>) {
        val realm = Realm.getDefaultInstance()
        var contentsList = pickRepository.getContents(PAGE_SIZE, PAGE_INDEX, realm)
        callback.onResult(contentsList.contents, null, PAGE_INDEX + 1)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CuratingContent>) {
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CuratingContent>) {
        val realm = Realm.getDefaultInstance()
        var contentsList = pickRepository.getContents(PAGE_SIZE, params.key, realm)
        var key = if (contentsList.hasMore) params.key + 1 else null
        callback.onResult(contentsList.contents, key)
    }

}