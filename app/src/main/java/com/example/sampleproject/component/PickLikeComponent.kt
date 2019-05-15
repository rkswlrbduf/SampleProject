package com.example.sampleproject.component

import com.example.sampleproject.presentation.pick.PickLikeFragment
import dagger.Component

@Component(modules = [PickLikeModule::class])
interface PickLikeComponent {
    fun inject(fragment: PickLikeFragment): PickLikeFragment
}