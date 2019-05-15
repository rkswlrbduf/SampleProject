package com.example.sampleproject.component

import com.example.sampleproject.pickdeatil.PickDetailPresenter
import com.example.sampleproject.data.source.PickRepository
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration

@Module
class PickDetailModule {

    @Provides
    fun provideRepo(): PickRepository {
        return PickRepository()
    }

    @Provides
    fun providePresenter(pickRepository: PickRepository): PickDetailPresenter {
        return PickDetailPresenter(pickRepository)
    }

}
