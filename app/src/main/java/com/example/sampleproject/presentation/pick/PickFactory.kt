package com.example.sampleproject.presentation.pick

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import io.realm.Realm
import javax.inject.Inject

class PickFactory @Inject constructor(var pickRepositoryImpl: PickRepositoryImpl, var realm: Realm): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PickViewModel(pickRepositoryImpl, realm) as T
    }
}