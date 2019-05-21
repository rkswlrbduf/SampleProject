package com.example.sampleproject.base

import dagger.Component

@Component(modules = arrayOf(BaseAppModule::class))
interface BaseAppComponent {
    fun inject(app: BaseApp)
}