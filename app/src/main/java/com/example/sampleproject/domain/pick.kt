package com.example.sampleproject.domain

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.annotations.PrimaryKey
import java.util.*
import kotlin.collections.ArrayList

data class PagedCuratingContents(var contents: List<CuratingContent>, var hasMore: Boolean = false)

open class CuratingContent(
    @PrimaryKey
    var id: Int = 0,
    var title: String = "",
    @SerializedName("created_at") var createdAt: Date = Date(),
    @SerializedName("like_count") var likeCount: Int = 0,
    @SerializedName("comment_count") var commentCount: Int = 0,
    @SerializedName("view_count") var viewCount: Int? = null,
    @SerializedName("is_liked") var isLiked: Int = 0,
    var thumbnail: String = "",
    var tag: Int = 0,
    @SerializedName("teacher_nickname") var teacherNickName: String = "",
    @SerializedName("profile_image_key") var profileImageKey: String? = null,
    var messages: RealmList<PickChatMessage> = RealmList()
): RealmObject()

open class PickChatMessage(
    var message: String? = null,
    @SerializedName("user_nickname") var userNickname: String? = null,
    @SerializedName("profile_image") var profileImage: String? = null,
    @SerializedName("chat_type") var chatType: Int = 0,
    @SerializedName("image_url") var imageURL: String? = null
) : RealmObject()

