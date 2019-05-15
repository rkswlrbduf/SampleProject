package com.example.sampleproject.component

import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import com.example.sampleproject.presentation.pickdeatil.PickListPresenter
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.realm.Realm

@Module
class PickListModule {

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
    fun providePresenter(pickRepository: PickRepositoryImpl): PickListPresenter {
        return PickListPresenter(pickRepository)
    }

}
