package com.example.sampleproject.component

import com.example.sampleproject.pick.PickActivity
import com.example.sampleproject.pick.list.PickListModule
import com.example.sampleproject.pickdeatil.PickDetailActivity
import dagger.Component

@Component(modules = [PickListModule::class])
interface PickComponent {
    fun inject(activity: PickDetailActivity): PickDetailActivity
    fun inject(activity: PickActivity): PickActivity
}