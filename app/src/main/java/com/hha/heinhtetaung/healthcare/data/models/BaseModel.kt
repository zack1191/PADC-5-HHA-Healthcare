package com.hha.heinhtetaung.healthcare.data.models

import android.content.Context
import com.google.gson.Gson
import com.hha.heinhtetaung.healthcare.network.HealthCareApi
import com.hha.heinhtetaung.healthcare.persistence.database.AppDatabase
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by E5 on 7/13/2018.
 */

abstract class BaseModel protected constructor(context: Context) {

    protected var mTheApi: HealthCareApi
    protected var mTheDB: AppDatabase

    init {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/mm-healthcare/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()

        mTheApi = retrofit.create<HealthCareApi>(HealthCareApi::class.java)
        mTheDB = AppDatabase.getDatabase(context)
    }
}