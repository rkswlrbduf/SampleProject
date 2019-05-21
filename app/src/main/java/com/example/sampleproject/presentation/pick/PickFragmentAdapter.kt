package com.example.sampleproject.presentation.pick

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.sampleproject.presentation.pick.PickLikeFragment
import com.example.sampleproject.presentation.pick.PickListFragment


class PickFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return PickListFragment.newInstance()
            1 -> return PickLikeFragment.newInstance()
        }
        return null
    }

    override fun getCount(): Int {
        return 2
    }
}