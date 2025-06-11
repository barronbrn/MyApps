package com.example.myapps.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "interests")
data class Interest(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val type: String,
    val item: String
)