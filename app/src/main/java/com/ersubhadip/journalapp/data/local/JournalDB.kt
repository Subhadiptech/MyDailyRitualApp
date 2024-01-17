package com.ersubhadip.journalapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [JournalEntity::class], version = 1)
abstract class JournalDB : RoomDatabase() {
    abstract fun journalDao(): JournalDao
}