package com.example.sampleproject

import com.example.sampleproject.data.CuratingContents
import com.google.gson.Gson
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PickRepositorylmpl {

    fun getContents(json: String): Single<CuratingContents> {
        val gson = Gson()
        var preMessage : CuratingContents = gson.fromJson<CuratingContents>(json, CuratingContents::class.java)
        var message: Single<CuratingContents> = Single.just(preMessage)
        return message.subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
    }

}