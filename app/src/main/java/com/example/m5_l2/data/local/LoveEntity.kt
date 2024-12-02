package com.example.m5_l2.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

const val DEFAULT_ID = 0

@Entity(tableName = "history")
data class LoveEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = DEFAULT_ID,
    val firstName: String,
    val secondName: String,
    val percentage: String,
    val result: String
)