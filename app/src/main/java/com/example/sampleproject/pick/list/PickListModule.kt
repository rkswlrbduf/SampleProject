package com.example.sampleproject.pick.list

import com.example.sampleproject.pickdeatil.PickDetailPresenter
import com.example.sampleproject.data.source.PickRepository
import com.example.sampleproject.pickdeatil.PickListPresenter
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration

@Module
class PickListModule {

    @Provides
    fun provideRepo(realm: Realm): PickRepository {
        return PickRepository(realm)
    }

    @Provides
    fun providePresenter(pickRepository: PickRepository): PickListPresenter {
        return PickListPresenter(pickRepository)
    }

    @Provides
    fun provideRealm(): Realm {
        return Realm.getDefaultInstance()
    }

}
