package id.deval.core.data.source.local.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import id.deval.core.data.source.local.entity.FavoriteGameEntity
import id.deval.core.data.source.local.room.converter.GameConverterHelper
import id.deval.core.data.source.local.room.dao.FavoriteGameDao

@Database(entities = [FavoriteGameEntity::class], version = 2, exportSchema = false)
@TypeConverters(GameConverterHelper::class)
abstract class FavoriteGameDatabase : RoomDatabase() {
    abstract fun favoriteGameDao() : FavoriteGameDao
}