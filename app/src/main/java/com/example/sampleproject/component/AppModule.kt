package com.example.sampleproject.component

import android.content.Context
import com.example.sampleproject.base.BaseApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: BaseApp) {

    @Provides
    fun app(): BaseApp {
        return app
    }

}