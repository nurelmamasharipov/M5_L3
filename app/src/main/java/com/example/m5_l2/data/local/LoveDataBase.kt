package com.example.m5_l2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LoveEntity::class], version = 2, exportSchema = false)
abstract class LoveDataBase : RoomDatabase() {

    abstract fun loveDao(): LoveDao

}