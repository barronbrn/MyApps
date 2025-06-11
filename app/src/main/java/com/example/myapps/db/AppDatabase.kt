package com.example.myapps.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapps.data.models.DailyActivity
import com.example.myapps.data.models.Friend
import com.example.myapps.data.models.GalleryItem
import com.example.myapps.data.models.Interest
import com.example.myapps.data.models.MusicItem
import com.example.myapps.data.models.UserProfile
import com.example.myapps.data.models.VideoItem


// Mendefinisikan kelas database Room
@Database(
    entities = [
        UserProfile::class,
        Interest::class,
        DailyActivity::class,
        Friend::class,
        GalleryItem::class,
        MusicItem::class,
        VideoItem::class
    ],
    version = 4,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userProfileDao(): UserProfileDao
    abstract fun interestDao(): InterestDao
    abstract fun dailyActivityDao(): DailyActivityDao
    abstract fun friendDao(): FriendDao
    abstract fun galleryItemDao(): GalleryItemDao
    abstract fun musicItemDao(): MusicItemDao
    abstract fun videoItemDao(): VideoItemDao
}