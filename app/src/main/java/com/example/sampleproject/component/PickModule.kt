package com.example.sampleproject.component

import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import com.example.sampleproject.presentation.pick.fragment.PickViewModelFactory
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
    fun provideRepo(realm: Realm, gson: Gson): PickRepositoryImpl {
        return PickRepositoryImpl(realm, gson)
    }

    @Provides
    fun provideFactory(
        pickRepositoryImpl: PickRepositoryImpl,
        contentsListDataSourceFactory: ContentsListDataSourceFactory
    ): PickViewModelFactory {
        return PickViewModelFactory(pickRepositoryImpl, contentsListDataSourceFactory)
    }

    @Provides
    fun provideListDataSourceFactory(contentsListDataSource: ContentsListDataSource): ContentsListDataSourceFactory {
        return ContentsListDataSourceFactory(contentsListDataSource)
    }

    @Provides
    fun provideListDataSource(pickRepositoryImpl: PickRepositoryImpl): ContentsListDataSource {
        return ContentsListDataSource(pickRepositoryImpl)
    }

}