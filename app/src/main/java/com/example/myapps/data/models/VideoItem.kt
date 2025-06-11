package com.example.myapps.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "video_items")
data class VideoItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val thumbnailUrl: String,
    val videoUrl: String
)
