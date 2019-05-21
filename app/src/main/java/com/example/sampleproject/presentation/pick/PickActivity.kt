package com.example.sampleproject.presentation.pick

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sampleproject.R
import com.example.sampleproject.base.BaseApp
import com.example.sampleproject.component.DaggerPickComponent
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_pick.*
import javax.inject.Inject

class PickActivity : AppCompatActivity() {

    @Inject
    lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick)

        Realm.init(this)

        DaggerPickComponent.builder().baseAppComponent(BaseApp.component).build().inject(this)

        view_pager.adapter =
            PickFragmentAdapter(supportFragmentManager)
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
