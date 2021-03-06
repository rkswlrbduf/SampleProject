package com.example.sampleproject.presentation.pick

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sampleproject.R
import com.example.sampleproject.base.BaseApp
import com.example.sampleproject.component.DaggerPickComponent
import com.example.sampleproject.databinding.FragmentListBinding
import com.example.sampleproject.presentation.pick.fragment.PickViewModel
import com.example.sampleproject.presentation.pick.fragment.PickViewModelFactory
import com.example.sampleproject.presentation.pick.fragment.list.PickListRecylcerAdapter
import com.example.sampleproject.presentation.pickdeatil.PickDetailActivity
import javax.inject.Inject

class PickListFragment : Fragment() {

    @Inject
    lateinit var factory: PickViewModelFactory
    private lateinit var binding: FragmentListBinding
    private lateinit var mAdapter: PickListRecylcerAdapter
    private lateinit var model: PickViewModel

    companion object {
        fun newInstance(): PickListFragment = PickListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        return binding.root
    }

    fun initUI() {
        mAdapter = PickListRecylcerAdapter(
            activity as PickActivity,
            object :
                PickListRecylcerAdapter.OnPickItemClickListener {
                override fun onPickItemClicked(contentsId: Int) {
                    startActivity(PickDetailActivity.getStartIntent(activity as PickActivity, contentsId))
                }
            }).also {
            binding.recv.layoutManager = GridLayoutManager(activity, 2)
            binding.recv.adapter = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerPickComponent.builder().baseAppComponent(BaseApp.component).build().inject(this)
        model = ViewModelProviders.of(this, factory).get(PickViewModel::class.java)
        initUI()
        model.getPickList().observe(this, Observer {
            mAdapter.submitList(it)
        })
    }

}