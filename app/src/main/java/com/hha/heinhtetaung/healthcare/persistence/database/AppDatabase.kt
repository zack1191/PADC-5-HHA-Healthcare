package com.hha.heinhtetaung.healthcare.persistence.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.hha.heinhtetaung.healthcare.data.vo.HealthCareVO
import com.hha.heinhtetaung.healthcare.persistence.dao.HealCareDao

/**
 * Created by E5 on 7/13/2018.
 */

@Database(entities = arrayOf(HealthCareVO::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun healcareinfoDao(): HealCareDao


    companion object {
        private val DB_NAME = "Healthcare.DB"
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
            }
            val i = INSTANCE
            return i!!
        }
    }

}