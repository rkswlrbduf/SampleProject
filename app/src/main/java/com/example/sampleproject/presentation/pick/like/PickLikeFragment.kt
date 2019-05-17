package com.example.sampleproject.presentation.pick

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sampleproject.R
import com.example.sampleproject.component.DaggerPickComponent
import com.example.sampleproject.presentation.pickdeatil.PickDetailActivity
import kotlinx.android.synthetic.main.fragment_like.*
import javax.inject.Inject

class PickLikeFragment : Fragment() {

    @Inject
    lateinit var factory: PickFactory
    private lateinit var mAdapter: PickRecylcerAdapter
    private lateinit var model: PickViewModel

    companion object {
        fun newInstance(): PickLikeFragment = PickLikeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_like, container, false)

    fun init() {
        mAdapter = PickRecylcerAdapter(activity as PickActivity, object : PickRecylcerAdapter.OnPickItemClickListener {
            override fun onPickItemClicked(contentsId: Int) {
                startActivity(PickDetailActivity.getStartIntent(activity as PickActivity, contentsId))
            }
        }).also {
            likedRecyclerView.layoutManager = GridLayoutManager(activity, 2)
            likedRecyclerView.adapter = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerPickComponent.builder().build().inject(this)
        model = ViewModelProviders.of(this, factory).get(PickViewModel::class.java)
        init()
        model.likedContents.observe(this, Observer {
            mAdapter.addMoreDatas(it!!)
            mAdapter.notifyDataSetChanged()
        })

    }

}