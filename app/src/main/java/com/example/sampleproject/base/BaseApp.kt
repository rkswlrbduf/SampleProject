package com.example.sampleproject.base

import android.app.Application
import android.content.Context
import com.example.sampleproject.component.*

class BaseApp : Application() {


    companion object {
        lateinit var context: Context
        lateinit var component: BaseAppComponent
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerBaseAppComponent.builder().baseAppModule(BaseAppModule(this)).build()
        component.inject(this)

        context = this

    }

}