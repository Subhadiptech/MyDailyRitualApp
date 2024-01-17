package com.ersubhadip.journalapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface JournalDao {
    @Insert
    suspend fun createJournal(journal: JournalEntity)

    @Query("SELECT * FROM journals")
    suspend fun getJournal(): Flow<List<JournalEntity>>

    @Delete
    suspend fun deleteJournal(journal: JournalEntity)
}