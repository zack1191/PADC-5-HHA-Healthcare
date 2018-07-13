package com.hha.heinhtetaung.healthcare.adapters

import android.content.Context
import android.view.ViewGroup
import com.hha.heinhtetaung.healthcare.R
import com.hha.heinhtetaung.healthcare.data.vo.HealthCareVO
import com.hha.heinhtetaung.healthcare.delegates.HealthCareDelegate
import com.hha.heinhtetaung.healthcare.viewholders.BaseViewHolder
import com.hha.heinhtetaung.healthcare.viewholders.HealthCareViewHolder

/**
 * Created by E5 on 7/11/2018.
 */
class HealthCareAdapter(context: Context, private val mHealthCareDelegate: HealthCareDelegate) : BaseRecyclerAdapter<HealthCareAdapter, HealthCareVO>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<HealthCareVO> {
        val healthItemView = mLayoutInflator.inflate(R.layout.item_health_care, parent, false)
        return HealthCareViewHolder(healthItemView, mHealthCareDelegate)
    }
}