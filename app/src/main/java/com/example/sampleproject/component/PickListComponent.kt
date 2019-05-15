package com.example.sampleproject.component

import com.example.sampleproject.presentation.pick.PickListFragment
import dagger.Component

@Component(modules = [PickListModule::class])
interface PickListComponent {
    fun inject(fragment: PickListFragment): PickListFragment
}