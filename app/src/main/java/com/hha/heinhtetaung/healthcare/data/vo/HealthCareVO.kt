package com.hha.heinhtetaung.healthcare.data.vo

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.hha.heinhtetaung.healthcare.data.vo.AuthorVO
import io.reactivex.annotations.NonNull

/**
 * Created by E5 on 7/11/2018.
 */
@Entity(tableName = "HealthCare")
open class HealthCareVO {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Long = 0

    var title: String? = null

    var image: String? = null

    @SerializedName("short-description")
    var shortDescription: String? = null

    @SerializedName("published-date")
    var publishedDate: String? = null

    @Embedded
    var author: AuthorVO? = null

    @SerializedName("complete-url")
    var completeUrl: String? = null

    @SerializedName("info-type")
    var infoType: String? = null
}