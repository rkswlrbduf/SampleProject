package com.example.sampleproject.component

import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import com.example.sampleproject.presentation.pick.fragment.PickViewModelFactory
import com.example.sampleproject.presentation.pick.fragment.like.ContentsLikeDataSource
import com.example.sampleproject.presentation.pick.fragment.like.ContentsLikeDataSourceFactory
import com.example.sampleproject.presentation.pick.fragment.list.ContentsListDataSource
import com.example.sampleproject.presentation.pick.fragment.list.ContentsListDataSourceFactory
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.realm.Realm

@Module
class PickModule {

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    fun provideRealm(): Realm {
        return Realm.getDefaultInstance()
    }

    @Provides
    fun provideRepo(gson: Gson): PickRepositoryImpl {
        return PickRepositoryImpl(gson)
    }

    @Provides
    fun provideFactory(contentsListDataSourceFactory: ContentsListDataSourceFactory, contentsLikeDataSourceFactory: ContentsLikeDataSourceFactory): PickViewModelFactory {
        return PickViewModelFactory(contentsListDataSourceFactory, contentsLikeDataSourceFactory)
    }

    @Provides
    fun provideListDataSourceFactory(contentsListDataSource: ContentsListDataSource): ContentsListDataSourceFactory {
        return ContentsListDataSourceFactory(contentsListDataSource)
    }

    @Provides
    fun provideListDataSource(pickRepositoryImpl: PickRepositoryImpl) : ContentsListDataSource {
        return ContentsListDataSource(pickRepositoryImpl)
    }

    @Provides
    fun provideLikeDataSourceFactory(contentsLikeDataSource: ContentsLikeDataSource): ContentsLikeDataSourceFactory {
        return ContentsLikeDataSourceFactory(contentsLikeDataSource)
    }

    @Provides
    fun provideLikeDataSource(pickRepositoryImpl: PickRepositoryImpl) : ContentsLikeDataSource {
        return ContentsLikeDataSource(pickRepositoryImpl)
    }


}