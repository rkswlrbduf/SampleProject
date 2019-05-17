package com.example.sampleproject.component

import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import com.example.sampleproject.presentation.pick.PickFactory
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.realm.Realm

@Module
class PickLikeModule {

    @Provides
    fun provideFactory(pickRepository: PickRepositoryImpl, realm: Realm): PickFactory {
        return PickFactory(pickRepository, realm)
    }

}
