package com.hha.heinhtetaung.healthcare.network

import com.hha.heinhtetaung.healthcare.network.responses.GetHealthCareResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by E5 on 7/13/2018.
 */
interface HealthCareApi {

    @FormUrlEncoded
    @POST("GetHealthcareInfo.php")
    fun loadHealthCareinfo(
            @Field("access_token") accessToken: String): Observable<GetHealthCareResponse>

}