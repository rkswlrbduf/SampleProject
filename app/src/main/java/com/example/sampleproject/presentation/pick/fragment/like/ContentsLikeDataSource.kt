package com.example.sampleproject.presentation.pick.fragment.like

import android.arch.paging.PageKeyedDataSource
import android.util.Log
import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import com.example.sampleproject.domain.CuratingContent
import io.realm.Realm
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContentsLikeDataSource @Inject constructor(var pickRepository: PickRepositoryImpl) : PageKeyedDataSource<Int, CuratingContent>() {

    companion object {
        var PAGE_SIZE = 10
        var PAGE_INDEX = 1
    }

    init {
        PAGE_INDEX = 1
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, CuratingContent>) {
        val realm = Realm.getDefaultInstance()
        var contentsLike = pickRepository.getLikedContents(PAGE_SIZE, PAGE_INDEX, realm)
        callback.onResult(contentsLike.contents, null, PAGE_INDEX + 1)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CuratingContent>) {
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CuratingContent>) {
        val realm = Realm.getDefaultInstance()
        var contentsLike = pickRepository.getLikedContents(PAGE_SIZE, params.key, realm)
        var key = if (contentsLike.hasMore) params.key + 1 else null
        callback.onResult(contentsLike.contents, key)
    }

}