package com.example.sampleproject.component

import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import com.example.sampleproject.presentation.pick.like.PickLikeViewModelFactory
import dagger.Module
import dagger.Provides
import io.realm.Realm

@Module
class PickLikeModule {

    @Provides
    fun provideFactory(pickRepository: PickRepositoryImpl): PickLikeViewModelFactory {
        return PickLikeViewModelFactory(pickRepository)
    }

}
