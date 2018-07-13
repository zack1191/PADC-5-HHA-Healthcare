package com.hha.heinhtetaung.healthcare.data.models

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.hha.heinhtetaung.healthcare.HealthCareApp
import com.hha.heinhtetaung.healthcare.data.vo.HealthCareVO
import com.hha.heinhtetaung.healthcare.network.responses.GetHealthCareResponse
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by E5 on 7/13/2018.
 */
class HealthCareModel(context: Context) : BaseModel(context) {

    companion object {
        private var INSTANCE: HealthCareModel? = null

        fun getInstance(): HealthCareModel {
            if (INSTANCE == null) {
                throw RuntimeException("HealthcareModel is being invoked before initializing.")
            }

            val i = INSTANCE
            return i!!
        }

        fun initHealthcareModel(context: Context) {
            INSTANCE = HealthCareModel(context)
        }
    }

    fun startLoadingHealthCareInfo(healthcareLD: MutableLiveData<List<HealthCareVO>>?) {
        mTheApi.loadHealthCareinfo(HealthCareApp.ACCESS_TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<GetHealthCareResponse> {

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {
                        healthcareLD!!.value = (mTheDB!!.healcareinfoDao().getAllHealthCareInfo())
                    }

                    override fun onComplete() {

                    }

                    override fun onNext(t: GetHealthCareResponse) {
                        if (t.getHealthcareInfo().isNotEmpty()) {
                            storetoDatabase(t.getHealthcareInfo())
                            healthcareLD!!.value = (t.getHealthcareInfo())
                        }
                    }

                })
    }

    private fun storetoDatabase(healthcareList: List<HealthCareVO>) {
        mTheDB!!.healcareinfoDao().insertAll(healthcareList)
    }

    fun getAllHealthInfo(): LiveData<List<HealthCareVO>> {
        return mTheDB!!.healcareinfoDao().getAllData()
    }

}