package com.example.myapps.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myapps.db.AppDatabase
import com.example.myapps.repository.AppRepository
import com.example.myapps.utils.DummyData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "myapps_db"
        )
            .fallbackToDestructiveMigration()
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    CoroutineScope(Dispatchers.IO).launch {

                        val database = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "myapps_db").build()

                        val userProfileDao = database.userProfileDao()
                        val dailyActivityDao = database.dailyActivityDao()
                        val friendDao = database.friendDao()
                        val galleryItemDao = database.galleryItemDao()
                        val interestDao = database.interestDao()
                        val musicItemDao = database.musicItemDao()
                        val videoItemDao = database.videoItemDao()

                        userProfileDao.insertUserProfile(DummyData.getUserProfile())
                        dailyActivityDao.insertAllDailyActivities(DummyData.getDailyActivities())
                        friendDao.insertAllFriends(DummyData.getFriends())
                        galleryItemDao.insertAllGalleryItems(DummyData.getGalleryItems())
                        interestDao.insertAllInterests(DummyData.getInterests())
                        musicItemDao.insertAllMusicItems(DummyData.getMusicItems())
                        videoItemDao.insertAllVideoItems(DummyData.getVideoItems())

                        database.close()
                        println("Dummy data inserted during onCreate!")
                    }
                }
            })
            .build()
    }

    // Menyediakan DAO dari database
    @Singleton
    @Provides
    fun provideUserProfileDao(database: AppDatabase) = database.userProfileDao()

    @Singleton
    @Provides
    fun provideInterestDao(database: AppDatabase) = database.interestDao()

    @Singleton
    @Provides
    fun provideDailyActivityDao(database: AppDatabase) = database.dailyActivityDao()

    @Singleton
    @Provides
    fun provideFriendDao(database: AppDatabase) = database.friendDao()

    @Singleton
    @Provides
    fun provideGalleryDao(database: AppDatabase) = database.galleryItemDao()

    @Singleton
    @Provides
    fun provideMusicItemDao(database: AppDatabase) = database.musicItemDao()

    @Singleton
    @Provides
    fun provideVideoItemDao(database: AppDatabase) = database.videoItemDao()


    @Singleton
    @Provides
    fun provideAppRepository(
        userProfileDao: com.example.myapps.db.UserProfileDao,
        interestDao: com.example.myapps.db.InterestDao,
        dailyActivityDao: com.example.myapps.db.DailyActivityDao,
        friendDao: com.example.myapps.db.FriendDao,
        galleryItemDao: com.example.myapps.db.GalleryItemDao,
        musicItemDao: com.example.myapps.db.MusicItemDao,
        videoItemDao: com.example.myapps.db.VideoItemDao
    ): AppRepository {
        return AppRepository(
            userProfileDao,
            interestDao,
            dailyActivityDao,
            friendDao,
            galleryItemDao,
            musicItemDao,
            videoItemDao
        )
    }

}