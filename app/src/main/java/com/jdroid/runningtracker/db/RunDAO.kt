package com.jdroid.runningtracker.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run): Long

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("select * from running_table order by timeInMillis desc")
    fun getAllRunsByDate(): LiveData<List<Run>>

    @Query("select * from running_table order by caloriesBurned desc")
    fun getAllRunsByCalories(): LiveData<List<Run>>

    @Query("select * from running_table order by avgSpeedInKM desc")
    fun getAllRunsBySpeed(): LiveData<List<Run>>

    @Query("select * from running_table order by distanceInMeter desc")
    fun getAllRunsByDistance(): LiveData<List<Run>>

    @Query("select sum(timeInMillis) from running_table")
    fun getTotalTimeInMillis(): LiveData<Long>

    @Query("select sum(caloriesBurned) from running_table")
    fun getTotalCaloriesBurned(): LiveData<Int>

    @Query("select sum(distanceInMeter) from running_table")
    fun getTotalDistance(): LiveData<Int>

    @Query("select avg(avgSpeedInKM) from running_table")
    fun getAvgSpeed(): LiveData<Float>

}