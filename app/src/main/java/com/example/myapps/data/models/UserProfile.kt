package com.example.myapps.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile")
data class UserProfile(
    @PrimaryKey val id: Int = 1,
    val name: String,
    val photoUrl: String,
    val description: String,
    val profession: String,
    val quote: String
)
