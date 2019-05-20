package com.example.sampleproject.presentation.pick

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sampleproject.R
import com.example.sampleproject.base.BaseApp
import com.example.sampleproject.component.AppComponent
import com.example.sampleproject.component.AppModule
import com.example.sampleproject.component.DaggerPickComponent
import com.example.sampleproject.domain.CuratingContents
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_pick.*
import javax.inject.Inject

class PickActivity : AppCompatActivity() {

    @Inject
    lateinit var realm: Realm

    companion object {

        val REQUEST_CONTENTS_ID = "contents_id"

        fun getStartIntent(context: Context, contentsId: Int): Intent {
            val intent = Intent(context, PickActivity::class.java)
            intent.putExtra(REQUEST_CONTENTS_ID, contentsId)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick)

        Realm.init(this)

        DaggerPickComponent.builder().appComponent(BaseApp.component).build().inject(this)

        view_pager.adapter = PickFragmentAdapter(supportFragmentManager)
        nav_view.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menu_list -> {
                    view_pager.setCurrentItem(0, true)
                }
                R.id.menu_like -> {
                    view_pager.setCurrentItem(1, true)
                }
            }
            false
        }

    }

}
