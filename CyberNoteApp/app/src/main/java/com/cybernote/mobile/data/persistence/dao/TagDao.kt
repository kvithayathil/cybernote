package com.cybernote.mobile.data.persistence.dao

import androidx.room.*
import com.cybernote.mobile.data.persistence.entity.NoteTag

@Dao
interface TagDao {

    @Query("SELECT * FROM tag ORDER BY datetime(created) desc")
    fun getAll(): List<NoteTag>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tag: NoteTag)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg tag: NoteTag)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(tag: NoteTag)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateAll(vararg tag: NoteTag)

    @Delete
    fun delete(tag: NoteTag)

    @Delete
    fun deleteAll(vararg tag: NoteTag)
}