package com.example.sampleproject.presentation.pick

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sampleproject.R
import com.example.sampleproject.component.DaggerPickLikeComponent
import com.example.sampleproject.domain.CuratingContents
import com.example.sampleproject.presentation.pickdeatil.PickDetailActivity
import com.example.sampleproject.presentation.pickdeatil.PickLikeContract
import com.example.sampleproject.presentation.pickdeatil.PickLikePresenter
import kotlinx.android.synthetic.main.fragment_like.*
import javax.inject.Inject

class PickLikeFragment : Fragment(), PickLikeContract.View {

    @Inject
    lateinit var presenter: PickLikePresenter
    private lateinit var mAdapter: PickRecylcerAdapter

    companion object {
        fun newInstance(): PickLikeFragment = PickLikeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_like, container, false)

    override fun init() {
        mAdapter = PickRecylcerAdapter(
            activity as PickActivity,
            null,
            object : PickRecylcerAdapter.OnPickItemClickListener {
                override fun onPickItemClicked(contentsId: Int) {
                    startActivity(
                        PickDetailActivity.getStartIntent(activity as PickActivity, contentsId)
                    )
                }
            }).also {
            likedRecyclerView.layoutManager = GridLayoutManager(activity, 2)
            likedRecyclerView.adapter = it
        }
    }

    override fun loadLikedContents(contents: CuratingContents) {
        mAdapter.add(contents)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerPickLikeComponent.builder().build().inject(this)
        presenter.attachView(this)
        presenter.getLikedContents()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }
}