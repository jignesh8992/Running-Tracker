package com.jdroid.runningtracker.di

import android.content.Context
import androidx.room.Room
import com.jdroid.runningtracker.db.RunningDatabase
import com.jdroid.runningtracker.utilities.Constants.ROOM_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(app, RunningDatabase::class.java, ROOM_DATABASE_NAME).build()


    @Provides
    @Singleton
    fun provideRunningDao(db: RunningDatabase) = db.getRunDao()

}