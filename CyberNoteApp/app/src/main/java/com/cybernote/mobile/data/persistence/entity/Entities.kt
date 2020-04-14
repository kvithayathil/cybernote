package com.cybernote.mobile.data.persistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.OffsetDateTime
import java.util.*

@Entity(tableName = "tag")
data class NoteTag (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "tag_name" ) val name: String,
    @ColumnInfo(name = "created") val createdDate: OffsetDateTime = OffsetDateTime.now()
)

@Entity(tableName = "note")
data class NoteItem (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "uid") val uid: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "created") val createdDate: OffsetDateTime = OffsetDateTime.now(),
    @ColumnInfo(name = "last_updated") val lastUpdated: OffsetDateTime? = null
)

@Entity(tableName = "tagged_note", primaryKeys = ["note_id", "tag_id"])
data class TaggedNote (
    @ColumnInfo(name = "note_id") val noteId: Int,
    @ColumnInfo(name = "tag_id") val tagId: Int
)

