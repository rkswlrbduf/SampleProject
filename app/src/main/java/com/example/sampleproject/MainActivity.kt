package com.example.sampleproject

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MotionEvent
import com.bumptech.glide.Glide
import com.example.sampleproject.adapter.PickChatMessageAdapter
import com.example.sampleproject.data.CuratingContents
import com.example.sampleproject.data.PickChatMessage
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.coordinatorlayout_content.*
import kotlinx.android.synthetic.main.coordinatorlayout_header.*
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var pickRepository: PickRepositorylmpl = PickRepositorylmpl()

    lateinit var mAdapter: PickChatMessageAdapter
    var contents: CuratingContents? = null
    var lastPosition: Int = 1
    var messages: ArrayList<PickChatMessage>? = null
    var relateContents: ArrayList<CuratingContents>? = null
    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
        loadData()

    }

    fun initUI() {
        mAdapter = PickChatMessageAdapter(this, null)
        curating_content_recv.adapter = mAdapter
        curating_content_recv.layoutManager = LinearLayoutManager(this)

        curating_content_recv.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                var size: Int = messages?.size ?: 0

//                if (lastPosition == 1) hideTouchBotton()
//                if (lastPosition == 5 || size == lastPosition) hideUnusedLayout()

                if (size > lastPosition) {
                    mAdapter.addUserMessage(messages!![lastPosition++])
//                    scrollToBottom()
                } else if (size == lastPosition) {
                    lastPosition++

                    mAdapter.addMiddleMessage(message = getString(R.string.pick_end_header))
//                    if (relateContents != null) mAdapter.addRelateContentMessage(relateContents!!)
//                    scrollToBottom()
                }
                true
            }
            false
        }
    }

        /*btn_like.setOnClickListener {
            pickRepository.likeContents(this.contents?.id ?: 0).subscribe({
                if (curating_contents_detail_like_count_image.isSelected) {
                    curating_contents_detail_like_count_image.isSelected = false
                    curating_contents_detail_like_count.text = ((curating_contents_detail_like_count.text.toString().toInt()) - 1).toString()
                } else {
                    curating_contents_detail_like_count_image.isSelected = true
                    curating_contents_detail_like_count.text = ((curating_contents_detail_like_count.text.toString().toInt()) + 1).toString()
                }
            }, { e ->
                log(e)
            })
        }
        btn_comment.setOnClickListener {
            frameLayout.visibility = View.VISIBLE
            if (contents == null) return@setOnClickListener
            footer.visibility = View.INVISIBLE

            if (supportFragmentManager.findFragmentByTag("comment") != null
                    && supportFragmentManager.findFragmentByTag("comment") is PickChatCommentFragment) {
                var commentFragment = supportFragmentManager.findFragmentByTag("comment") as PickChatCommentFragment
                replaceFragmentToActivity(supportFragmentManager, commentFragment, R.id.frameLayout, tag = "comment")

            } else {
                replaceFragmentToActivity(supportFragmentManager, PickChatCommentFragment.newInstance(contents_id = contents!!.id, comment_count = contents!!.commentCount), R.id.frameLayout, tag = "comment")

            }
        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            ic_share.visibility = View.GONE
        }

        ic_share.setOnClickListener {
            startAskToParentInKakao(contents)
        }*/

    fun loadData() {
        disposable = pickRepository.getContents(loadJSONFromAsset()).subscribe({ contents ->
            this.contents = contents

            curating_contents_detail_title.text = contents.title
            Glide.with(this).load(contents.profileImageKey).into(curating_contents_detail_author_profile_image)
            curating_contents_detail_author_nickname.text = contents.teacherNickName
            curating_contents_detail_created_at.text = getStringYMD(contents.createdAt)
            /*curating_contents_detail_like_count.text = contents.likeCount.toString()
            curating_contents_detail_comment_count.text = contents.commentCount.toString()
            curating_contents_detail_like_count_image.isSelected = contents.isLiked == 1
*/
            //mAdapter.addContentMessage(contents)
            mAdapter.addUserMessage(contents.messages[0])
            messages = contents.messages

            /*pickRepository.relatedContents(contents.id, contents.tag).subscribe({ contentsList ->
                relateContents = contentsList
            }, { ee ->
                Log.d("TAG", ee)
            })*/


        }, { e ->
            Log.d("TAG", e.message)
        })

    }

    fun scrollToBottom() {
        curating_content_recv.smoothScrollToPosition(mAdapter.itemCount - 1)
    }

    fun loadJSONFromAsset(): String {
        var json: String
        try {
            val inputStream = assets.open("sample_chat.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json

    }

    fun getStringYMD(date: Date?): String = SimpleDateFormat(this.getString(R.string.date_format_YMD)).format(date)

}
