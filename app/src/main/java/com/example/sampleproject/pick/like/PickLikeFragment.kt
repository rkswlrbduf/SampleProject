package com.example.sampleproject.pick

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sampleproject.R
import com.example.sampleproject.pickdeatil.PickLikeContract

class PickLikeFragment: Fragment(), PickLikeContract.View {

    companion object {
        fun newInstance() : PickLikeFragment = PickLikeFragment()
    }

    override fun init() {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_like, container, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }
}