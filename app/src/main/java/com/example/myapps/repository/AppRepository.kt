package com.example.myapps.repository

import com.example.myapps.data.models.DailyActivity
import com.example.myapps.data.models.Friend
import com.example.myapps.data.models.GalleryItem
import com.example.myapps.data.models.Interest
import com.example.myapps.data.models.MusicItem
import com.example.myapps.data.models.UserProfile
import com.example.myapps.data.models.VideoItem
import com.example.myapps.db.DailyActivityDao
import com.example.myapps.db.FriendDao
import com.example.myapps.db.GalleryItemDao
import com.example.myapps.db.InterestDao
import com.example.myapps.db.MusicItemDao
import com.example.myapps.db.UserProfileDao
import com.example.myapps.db.VideoItemDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val userProfileDao: UserProfileDao,
    private val interestDao: InterestDao,
    private val dailyActivityDao: DailyActivityDao,
    private val friendDao: FriendDao,
    private val galleryItemDao: GalleryItemDao,
    private val musicItemDao: MusicItemDao,
    private val videoItemDao: VideoItemDao
) {
    fun getUserProfile(): Flow<UserProfile?> = userProfileDao.getUserProfile()
    suspend fun insertUserProfile(userProfile: UserProfile) = userProfileDao.insertUserProfile(userProfile)

    fun getInterestsByType(type: String): Flow<List<Interest>> = interestDao.getInterestsByType(type)
    suspend fun insertAllInterests(interests: List<Interest>) = interestDao.insertAllInterests(interests)

    fun getAllDailyActivities(): Flow<List<DailyActivity>> = dailyActivityDao.getAllDailyActivities()
    suspend fun insertAllDailyActivities(activities: List<DailyActivity>) = dailyActivityDao.insertAllDailyActivities(activities)

    fun getAllFriends(): Flow<List<Friend>> = friendDao.getAllFriends()
    suspend fun insertAllFriends(friends: List<Friend>) = friendDao.insertAllFriends(friends)

    fun getAllGalleryItems(): Flow<List<GalleryItem>> = galleryItemDao.getAllGalleryItems()
    suspend fun insertAllGalleryItems(items: List<GalleryItem>) = galleryItemDao.insertAllGalleryItems(items)

    fun getAllMusicItems(): Flow<List<MusicItem>> = musicItemDao.getAllMusicItems()
    suspend fun insertAllMusicItems(items: List<MusicItem>) = musicItemDao.insertAllMusicItems(items)


    fun getAllVideoItems(): Flow<List<VideoItem>> = videoItemDao.getAllVideoItems()
    suspend fun insertAllVideoItems(items: List<VideoItem>) = videoItemDao.insertAllVideoItems(items)
}