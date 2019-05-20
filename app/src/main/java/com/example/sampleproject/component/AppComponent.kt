package com.example.sampleproject.component

import com.example.sampleproject.base.BaseApp
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: BaseApp)
}