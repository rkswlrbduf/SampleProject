package com.example.sampleproject.component

import com.example.sampleproject.data.repositoryImpl.PickRepositoryImpl
import com.google.gson.Gson
import com.zhuinden.monarchy.Monarchy
import dagger.Module
import dagger.Provides
import io.realm.Realm

@Module
class BaseModule {

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    fun provideRealm(): Realm {
        return Realm.getDefaultInstance()
    }

    @Provides
    fun provideRepo(monarchy: Monarchy, gson: Gson): PickRepositoryImpl {
        return PickRepositoryImpl(monarchy, gson)
    }

    @Provides
    fun provideMonarchy(realm: Realm): Monarchy {
        return Monarchy.Builder().setRealmConfiguration(realm.configuration).build()
    }

}