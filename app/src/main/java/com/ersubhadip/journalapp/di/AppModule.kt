package com.ersubhadip.journalapp.di

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.ersubhadip.journalapp.data.local.JournalDB
import com.ersubhadip.journalapp.data.local.JournalDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideJournalDatabase(context: Context): JournalDB? {
        return databaseBuilder(
            context.applicationContext,
            JournalDB::class.java,
            "app_database"
        )
            .build()
    }

    @Provides
    @Singleton
    fun provideJournalDao(appDatabase: JournalDB): JournalDao? {
        return appDatabase.journalDao()
    }
}