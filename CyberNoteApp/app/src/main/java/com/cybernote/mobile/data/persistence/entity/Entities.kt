package com.cybernote.mobile.data.persistence.entity

import androidx.room.*
import org.threeten.bp.OffsetDateTime
import java.util.UUID

@Entity(tableName = "tag", indices = [Index(value = ["uuid"], unique = true)])
data class NoteTag(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "_id") val id: Long,
    @ColumnInfo(name = "uuid") val uuid: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "tag_name") val name: String,
    @ColumnInfo(name = "created") val createdDate: OffsetDateTime = OffsetDateTime.now()
)

@Entity(tableName = "note", indices = [Index(value = ["uuid"], unique = true)])
data class NoteItem(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "_id") val id: Long,
    @ColumnInfo(name = "uuid") val uuid: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "created") val createdDate: OffsetDateTime = OffsetDateTime.now(),
    @ColumnInfo(name = "last_updated") val lastUpdated: OffsetDateTime? = null
)

@Entity(
    tableName = "tagged_note", primaryKeys = ["note_id", "tag_id"],
    foreignKeys = [
        ForeignKey(
            entity = NoteItem::class,
            parentColumns = ["_id"],
            childColumns = ["note_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = NoteTag::class,
            parentColumns = ["_id"],
            childColumns = ["tag_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("tag_id"), Index("note_id")]
)
data class TaggedNote(
    @ColumnInfo(name = "note_id") val noteId: Long,
    @ColumnInfo(name = "tag_id") val tagId: Long
)

data class NoteWithTags(
    @Embedded
    val note: NoteItem,

    @Relation(
        parentColumn = "_id",
        entityColumn = "_id",
        associateBy = Junction(
            TaggedNote::class,
            parentColumn = "note_id",
            entityColumn = "tag_id"
        )
    )
    var tags: List<NoteTag> = arrayListOf()
)

data class TagWithNotes(
    @Embedded
    val note: NoteTag,

    @Relation(
        parentColumn = "_id",
        entityColumn = "_id",
        associateBy = Junction(
            TaggedNote::class,
            parentColumn = "tag_id",
            entityColumn = "note_id"
        )
    )
    var notes: List<NoteItem> = arrayListOf()
)

