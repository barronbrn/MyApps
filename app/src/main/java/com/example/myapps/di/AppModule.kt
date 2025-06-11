package com.example.myapps.di

import android.content.Context
import androidx.room.Room
import com.example.myapps.db.AppDatabase
import com.example.myapps.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
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
            "persona_app_db"
        )
            .fallbackToDestructiveMigration()
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


    @Singleton // Menyediakan AppRepository
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