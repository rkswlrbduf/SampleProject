package com.example.sampleproject.presentation.pick.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import com.example.sampleproject.domain.CuratingContents
import javax.inject.Inject

class PickListViewModel @Inject constructor(pickRepository: PickRepositoryImpl): ViewModel() {


    var listLiveData: LiveData<PagedList<CuratingContents>>

    init {
        listLiveData = pickRepository.getContents()
    }

}