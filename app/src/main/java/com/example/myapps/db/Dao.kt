package com.example.myapps.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapps.data.models.GalleryItem
import com.example.myapps.data.models.MusicItem
import com.example.myapps.data.models.VideoItem
import com.example.myapps.data.models.DailyActivity
import com.example.myapps.data.models.Friend
import com.example.myapps.data.models.Interest
import com.example.myapps.data.models.UserProfile

import kotlinx.coroutines.flow.Flow

// DAO untuk UserProfile
@Dao
interface UserProfileDao {
    @Query("SELECT * FROM user_profile LIMIT 1")
    fun getUserProfile(): Flow<UserProfile?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserProfile(userProfile: UserProfile)
}

// DAO untuk Interests
@Dao
interface InterestDao {
    @Query("SELECT * FROM interests WHERE type = :type ORDER BY item ASC")
    fun getInterestsByType(type: String): Flow<List<Interest>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInterest(interest: Interest)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllInterests(interests: List<Interest>)
}

// DAO untuk DailyActivity
@Dao
interface DailyActivityDao {
    @Query("SELECT * FROM daily_activities ORDER BY id DESC")
    fun getAllDailyActivities(): Flow<List<DailyActivity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDailyActivity(activity: DailyActivity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDailyActivities(activities: List<DailyActivity>)
}

// DAO untuk Friend
@Dao
interface FriendDao {
    @Query("SELECT * FROM friends ORDER BY name ASC")
    fun getAllFriends(): Flow<List<Friend>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFriend(friend: Friend)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFriends(friends: List<Friend>)
}

// DAO untuk GalleryItem
@Dao
interface GalleryItemDao {
    @Query("SELECT * FROM gallery_items ORDER BY id DESC")
    fun getAllGalleryItems(): Flow<List<GalleryItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGalleryItem(item: GalleryItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllGalleryItems(items: List<GalleryItem>)
}

// DAO untuk MusicItem
@Dao
interface MusicItemDao {
    @Query("SELECT * FROM music_items ORDER BY title ASC")
    fun getAllMusicItems(): Flow<List<MusicItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMusicItem(item: MusicItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMusicItems(items: List<MusicItem>)
}

// DAO untuk VideoItem
@Dao
interface VideoItemDao {
    @Query("SELECT * FROM video_items ORDER BY title ASC")
    fun getAllVideoItems(): Flow<List<VideoItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVideoItem(item: VideoItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllVideoItems(items: List<VideoItem>)
}