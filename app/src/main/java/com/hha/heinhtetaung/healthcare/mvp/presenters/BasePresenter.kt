package com.hha.heinhtetaung.healthcare.mvp.presenters

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.hha.heinhtetaung.healthcare.mvp.views.BaseView

/**
 * Created by E5 on 7/13/2018.
 */

abstract class BasePresenter<T : BaseView> : ViewModel() {

    lateinit var mView: T
    lateinit var mErrorLD: MutableLiveData<String>

    open fun initPresenter(mView: T) {
        this.mView = mView
        mErrorLD = MutableLiveData()
    }

}