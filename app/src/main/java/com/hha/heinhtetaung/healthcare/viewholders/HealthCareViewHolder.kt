package com.hha.heinhtetaung.healthcare.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.hha.heinhtetaung.healthcare.R.id.tvAuthorName
import com.hha.heinhtetaung.healthcare.data.vo.HealthCareVO
import com.hha.heinhtetaung.healthcare.delegates.HealthCareDelegate
import kotlinx.android.synthetic.main.item_health_care.view.*

/**
 * Created by E5 on 7/11/2018.
 */
class HealthCareViewHolder(itemView: View, private val mHealthCareDelegate: HealthCareDelegate) : BaseViewHolder<HealthCareVO>(itemView) {
    override fun setData(data: HealthCareVO) {
        mData = data
        itemView.tvAuthorName.text = data.author!!.authorName
        itemView.tvPostedDate.text = data.publishedDate
        Glide.with(itemView.context)
                .load(data.author!!.authorPicture)
                .into(itemView.ivAuthorPicture)
        itemView.tvTitleHealth.text = data.title
        itemView.tvHealthDisc.text = data.shortDescription
        if (data.image!!.isNotEmpty()) {
            Glide.with(itemView.context)
                    .load(data.image)
                    .into(itemView.ivHealth)

        } else {
            itemView.ivHealth.visibility = View.GONE
        }

    }

    override fun onClick(p0: View?) {
        mHealthCareDelegate.onTapHealthcare(this.mData!!)
    }

}