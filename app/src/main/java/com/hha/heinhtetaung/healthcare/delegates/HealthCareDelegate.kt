package com.hha.heinhtetaung.healthcare.delegates

import com.hha.heinhtetaung.healthcare.data.vo.HealthCareVO

/**
 * Created by E5 on 7/13/2018.
 */
interface HealthCareDelegate {
    fun onTapHealthcare(healthcareVO: HealthCareVO)
}