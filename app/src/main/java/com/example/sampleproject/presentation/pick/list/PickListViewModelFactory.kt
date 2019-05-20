package com.example.sampleproject.presentation.pick.list

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import io.realm.Realm
import javax.inject.Inject

class PickListViewModelFactory @Inject constructor(var pickRepositoryImpl: PickRepositoryImpl): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PickListViewModel(pickRepositoryImpl) as T
    }
}