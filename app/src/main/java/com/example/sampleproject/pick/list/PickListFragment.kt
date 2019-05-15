package com.example.sampleproject.pick

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sampleproject.R
import com.example.sampleproject.adapter.PickRecylcerAdapter
import com.example.sampleproject.data.CuratingContents
import com.example.sampleproject.pick.list.DaggerPickListComponent
import com.example.sampleproject.pickdeatil.PickDetailActivity
import com.example.sampleproject.pickdeatil.PickListContract
import com.example.sampleproject.pickdeatil.PickListPresenter
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class PickListFragment : Fragment(), PickListContract.View {

    @Inject
    lateinit var presenter: PickListPresenter
    private lateinit var mAdapter: PickRecylcerAdapter
    private var contents: ArrayList<CuratingContents>? = null

    companion object {
        fun newInstance(): PickListFragment = PickListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_list, container, false)

    override fun init() {
        mAdapter = PickRecylcerAdapter(activity as PickActivity,
            contents,
            object : PickRecylcerAdapter.OnPickItemClickListener {
                override fun onPickItemClicked(contentsId: Int) {
                    startActivity(
                        PickDetailActivity.getStartIntent(activity as PickActivity, contentsId)
                    )
                }
            }).also {
            recv.layoutManager = GridLayoutManager(activity, 2)
            recv.adapter = it
        }

    }

    override fun loadData(contents: CuratingContents) {
        mAdapter.add(contents)
        Log.d("TAG", "ADDED")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerPickListComponent.builder().build().inject(this)

        presenter.attachView(this)
        presenter.getData()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }
}