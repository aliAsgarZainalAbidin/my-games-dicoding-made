package id.deval.core.data.source.local.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import id.deval.core.data.source.local.entity.GenreEntity
import id.deval.core.data.source.local.room.converter.GameConverterHelper
import id.deval.core.data.source.local.room.dao.GenreDao

@Database(entities = [GenreEntity::class], version = 1, exportSchema = false)
@TypeConverters(GameConverterHelper::class)
abstract class GenreDatabase : RoomDatabase() {
    abstract fun genreDao() : GenreDao
}