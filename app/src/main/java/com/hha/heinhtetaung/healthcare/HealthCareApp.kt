package com.hha.heinhtetaung.healthcare

import android.app.Application
import com.hha.heinhtetaung.healthcare.data.models.HealthCareModel

/**
 * Created by E5 on 7/13/2018.
 */
class HealthCareApp : Application() {
    companion object {
        const val TAG = "Healthcare"
        const val ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916"
    }

    override fun onCreate() {
        super.onCreate()
        HealthCareModel.initHealthcareModel(applicationContext)

    }
}