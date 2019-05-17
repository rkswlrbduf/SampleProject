package com.example.sampleproject.component

import com.example.sampleproject.presentation.pick.PickActivity
import com.example.sampleproject.presentation.pick.PickLikeFragment
import com.example.sampleproject.presentation.pick.PickListFragment
import com.example.sampleproject.presentation.pickdeatil.PickDetailActivity
import dagger.Component

@Component(modules = arrayOf(BaseModule::class,PickLikeModule::class,PickLikeModule::class))
interface PickComponent {
    fun inject(activity: PickDetailActivity): PickDetailActivity
    fun inject(activity: PickActivity): PickActivity
    fun inject(fragment: PickLikeFragment): PickLikeFragment
    fun inject(fragment: PickListFragment): PickListFragment
}