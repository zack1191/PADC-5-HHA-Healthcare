package com.hha.heinhtetaung.healthcare.data.vo

import com.google.gson.annotations.SerializedName

/**
 * Created by E5 on 7/13/2018.
 */
open class AuthorVO {

    @SerializedName("author-id")
    var authorId: Long = 0

    @SerializedName("author-name")
    var authorName: String? = null

    @SerializedName("author-picture")
    var authorPicture: String? = null

}