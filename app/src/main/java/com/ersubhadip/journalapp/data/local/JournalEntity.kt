package com.ersubhadip.journalapp.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("journals")
data class JournalEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long,

    @ColumnInfo("title")
    val title: String,

    @ColumnInfo("body")
    val body: String
)