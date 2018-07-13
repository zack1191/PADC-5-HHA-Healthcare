package com.hha.heinhtetaung.healthcare.persistence.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.hha.heinhtetaung.healthcare.data.vo.HealthCareVO

/**
 * Created by E5 on 7/13/2018.
 */
@Dao
interface HealCareDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(healthcarelist: List<HealthCareVO>)

    @Query("select * from HealthCare")
    fun getAllHealthCareInfo(): List<HealthCareVO>


    @Query("select * from HealthCare")
    fun getAllData(): LiveData<List<HealthCareVO>>

}