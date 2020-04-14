package com.cybernote.mobile.data.persistence

import androidx.room.TypeConverter
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.*

object DbTypeConverter {

    @TypeConverter
    @JvmStatic
    fun toOffsetDateTime(value: String?): OffsetDateTime? {
        return value?.let {
            return DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(value, OffsetDateTime::from)
        }
    }

    @TypeConverter
    @JvmStatic
    fun fromOffsetDateTime(date: OffsetDateTime?): String? {
        return date?.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
    }

    @TypeConverter
    @JvmStatic
    fun toUuid(value: String): UUID = UUID.fromString(value)

    @TypeConverter
    @JvmStatic
    fun fromUuid(uuid: UUID): String = uuid.toString()
}