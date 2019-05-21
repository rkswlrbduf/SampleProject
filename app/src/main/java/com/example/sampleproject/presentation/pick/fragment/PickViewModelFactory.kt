package com.example.sampleproject.presentation.pick.fragment

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import com.example.sampleproject.presentation.pick.fragment.like.ContentsLikeDataSourceFactory
import com.example.sampleproject.presentation.pick.fragment.list.ContentsListDataSourceFactory
import io.realm.Realm
import javax.inject.Inject

class PickViewModelFactory @Inject constructor(var contentsListDataSourceFactory: ContentsListDataSourceFactory, var contentsLikeDataSourceFactory: ContentsLikeDataSourceFactory): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PickViewModel(contentsListDataSourceFactory, contentsLikeDataSourceFactory) as T
    }
}