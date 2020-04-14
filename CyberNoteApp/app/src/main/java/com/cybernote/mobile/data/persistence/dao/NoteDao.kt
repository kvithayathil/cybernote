package com.cybernote.mobile.data.persistence.dao

import androidx.room.*
import com.cybernote.mobile.data.persistence.entity.NoteItem

@Dao
interface NoteDao {

    @Query("SELECT * FROM note ORDER BY datetime(last_updated) desc, datetime(created) desc")
    fun getAll(): List<NoteItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tag: NoteItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg tag: NoteItem)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(tag: NoteItem)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateAll(vararg tag: NoteItem)

    @Delete
    fun delete(tag: NoteItem)

    @Delete
    fun deleteAll(vararg tag: NoteItem)
}