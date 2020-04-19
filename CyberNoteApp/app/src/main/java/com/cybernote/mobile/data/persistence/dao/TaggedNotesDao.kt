package com.cybernote.mobile.data.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Query
import com.cybernote.mobile.data.persistence.entity.TaggedNote

@Dao
interface TaggedNotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(join: TaggedNote)

    @Transaction
    @Query("SELECT * FROM tagged_note")
    fun getTaggedNotes(): List<TaggedNote>

}