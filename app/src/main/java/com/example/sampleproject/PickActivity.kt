package com.example.sampleproject

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.GestureDetector
import android.view.MotionEvent
import com.bumptech.glide.Glide
import com.example.sampleproject.adapter.PickChatMessageAdapter
import com.example.sampleproject.data.CuratingContents
import com.example.sampleproject.data.PickChatMessage
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class PickActivity : AppCompatActivity(), PickContact.View, GestureDetector.OnGestureListener {

    private lateinit var mAdapter: PickChatMessageAdapter
    private var messages: ArrayList<PickChatMessage>? = null
    private val presenter: PickPresenter = PickPresenter()
    private val gestureDetector: GestureDetector by lazy { GestureDetector(this, this) }

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
        setContentView(R.layout.activity_main)

        presenter.attachView(this)
        presenter.loadData()

    }

    override fun init() {

        mAdapter = PickChatMessageAdapter(this, null, object : PickChatMessageAdapter.PickChatCallback {
            override fun onPickItemClicked(contentsId: Int) {
                startActivity(PickActivity.getStartIntent(this@PickActivity, contentsId))
            }
        }).also {
            curating_content_recv.adapter = it
            curating_content_recv.layoutManager = LinearLayoutManager(this)
        }

        curating_content_recv.setOnTouchListener { _, event ->
            gestureDetector.onTouchEvent(event)
        }

        curating_contents_detail_like_count_image.setOnClickListener {
            presenter.toggleLikeBtn()
        }

    }

    override fun scrollToBottom() {
        curating_content_recv.smoothScrollToPosition(mAdapter.itemCount - 1)
    }

    override fun runToggleLikeBtn() {
        if (curating_contents_detail_like_count_image.isSelected) {
            curating_contents_detail_like_count_image.isSelected = false
            curating_contents_detail_like_count.text = ((curating_contents_detail_like_count.text.toString().toInt()) - 1).toString()
        } else {
            curating_contents_detail_like_count_image.isSelected = true
            curating_contents_detail_like_count.text = ((curating_contents_detail_like_count.text.toString().toInt()) + 1).toString()
        }
    }

    override fun runLoadData(contents: CuratingContents) {
        curating_contents_detail_title.text = contents.title
        Glide.with(this).load(contents.profileImageKey).into(curating_contents_detail_author_profile_image)
        curating_contents_detail_author_nickname.text = contents.teacherNickName
        curating_contents_detail_created_at.text = getStringYMD(contents.createdAt)
        mAdapter.addUserMessage(contents.messages[0])
        messages = contents.messages
    }

    override fun runAddUserMessage(message: PickChatMessage) {
        mAdapter.addUserMessage(message)
    }

    override fun runAddMiddleMessage(message: String) {
        mAdapter.addMiddleMessage(message)
    }

    override fun runRelatedMessage(lists: ArrayList<CuratingContents>) {
        mAdapter.addRelateContentMessage(lists)
    }

    // 유틸 클래스는 어디에 있는게 제일좋을지?
    fun getStringYMD(date: Date?): String = SimpleDateFormat("dd MMM YYYY").format(date)

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun onShowPress(e: MotionEvent?) {
    }

    override fun onSingleTapUp(e: MotionEvent): Boolean {
        if (presenter.recvTouched()) {
            curating_content_container.setTransitionDuration(1)
            curating_content_container.transitionToState(R.id.motion_end)
        }
        return true
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return false
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        return false
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        return false
    }

    override fun onLongPress(e: MotionEvent?) {
    }

}
