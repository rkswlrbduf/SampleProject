package com.example.sampleproject.pick.list

import com.example.sampleproject.pick.PickListFragment
import com.example.sampleproject.pickdeatil.PickDetailActivity
import dagger.Component

@Component(modules = [PickListModule::class])
interface PickListComponent {
    fun inject(fragment: PickListFragment): PickListFragment
}