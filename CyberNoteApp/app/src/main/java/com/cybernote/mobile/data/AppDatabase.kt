package com.cybernote.mobile.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cybernote.mobile.data.persistence.DbTypeConverter
import com.cybernote.mobile.data.persistence.dao.NoteDao
import com.cybernote.mobile.data.persistence.dao.TagDao
import com.cybernote.mobile.data.persistence.dao.TaggedNotesDao
import com.cybernote.mobile.data.persistence.entity.NoteItem
import com.cybernote.mobile.data.persistence.entity.NoteTag
import com.cybernote.mobile.data.persistence.entity.TaggedNote

@Database(entities = [NoteItem::class, NoteTag::class, TaggedNote::class], version = 1, exportSchema = true)
@TypeConverters(DbTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    abstract fun tagDao(): TagDao

    abstract fun taggedNotesDao(): TaggedNotesDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app.db")
                .build()
    }
}