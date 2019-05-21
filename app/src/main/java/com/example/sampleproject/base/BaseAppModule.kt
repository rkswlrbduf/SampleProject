package com.example.sampleproject.base

import dagger.Module
import dagger.Provides

@Module
class BaseAppModule(val app: BaseApp) {

    @Provides
    fun app(): BaseApp {
        return app
    }

}