package com.example.sampleproject.component

import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import com.example.sampleproject.presentation.pick.list.PickListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PickListModule {

    @Provides
    fun provideFactory(pickRepository: PickRepositoryImpl): PickListViewModelFactory {
        return PickListViewModelFactory(pickRepository)
    }

}
