package com.example.sampleproject.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class CuratingContents(
    var id: Int,
    var title: String,
    @SerializedName("created_at") var createdAt: Date,
    @SerializedName("like_count") var likeCount: Int,
    @SerializedName("comment_count") var commentCount: Int,
    @SerializedName("view_count") var viewCount: Int? = null,
    @SerializedName("is_liked") var isLiked: Int,
    var thumbnail: String,
    var tag: Int,
    @SerializedName("teacher_nickname") var teacherNickName: String,
    @SerializedName("profile_image_key") var profileImageKey: String?,
    var messages: ArrayList<PickChatMessage>
)


data class PickChatMessage(
    var message: String? = null,
    @SerializedName("user_nickname") var userNickname: String? = null,
    @SerializedName("profile_image") var profileImage: String? = null,
    @SerializedName("chat_type") var chatType: Int,
    @SerializedName("image_url") var imageURL: String? = null
)

