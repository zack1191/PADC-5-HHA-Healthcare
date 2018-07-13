package com.hha.heinhtetaung.healthcare.network.responses

import com.google.gson.annotations.SerializedName
import com.hha.heinhtetaung.healthcare.data.vo.HealthCareVO

/**
 * Created by E5 on 7/13/2018.
 */
class GetHealthCareResponse {


    var code: Long = 0

    var message: String? = null

    @SerializedName("healthcare-info")
    var healthCareInfo: List<HealthCareVO>? = null


    fun getHealthcareInfo(): List<HealthCareVO> {
        if (healthCareInfo == null) {
            healthCareInfo = ArrayList()
        }
        val healthcareInfoVal = healthCareInfo
        return healthcareInfoVal!!
    }

}