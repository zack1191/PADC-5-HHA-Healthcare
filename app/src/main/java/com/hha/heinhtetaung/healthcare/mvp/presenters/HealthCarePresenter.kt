package com.hha.heinhtetaung.healthcare.mvp.presenters

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.hha.heinhtetaung.healthcare.data.models.HealthCareModel
import com.hha.heinhtetaung.healthcare.data.vo.HealthCareVO
import com.hha.heinhtetaung.healthcare.delegates.HealthCareDelegate
import com.hha.heinhtetaung.healthcare.mvp.views.HealthCareView

/**
 * Created by E5 on 7/13/2018.
 */
class HealthCarePresenter : BasePresenter<HealthCareView>(), HealthCareDelegate {
    override fun onTapHealthcare(healthcareVO: HealthCareVO) {
        mView.launchHealthcare(healthcareVO.completeUrl!!)
    }

    private lateinit var healthcareLD: MutableLiveData<List<HealthCareVO>>

    override fun initPresenter(mView: HealthCareView) {
        super.initPresenter(mView)
        healthcareLD = MutableLiveData()

        HealthCareModel.getInstance().startLoadingHealthCareInfo(healthcareLD)
    }

    fun getHealthcareLD(): MutableLiveData<List<HealthCareVO>> {
        return healthcareLD
    }

//    override fun onTapHealthcareItem(healthcareVO: HealthCareVO) {
//        mView.launchHealthcareUrl(healthcareVO.completeUrl!!)
//    }
}