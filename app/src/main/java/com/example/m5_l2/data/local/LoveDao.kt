package com.example.m5_l2.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface LoveDao {

    @Insert
    fun insert(loveEntity: LoveEntity)

    @Delete
    suspend fun delete(loveResult: LoveEntity)

    @Query("SELECT * FROM history ORDER BY firstName ASC")
    fun getAllResultsSortedByName(): LiveData<List<LoveEntity>>
}