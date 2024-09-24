package id.deval.core.data.source.local.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import id.deval.core.data.source.local.entity.GameEntity
import id.deval.core.data.source.local.room.converter.GameConverterHelper
import id.deval.core.data.source.local.room.dao.GameDao

@Database(entities = [GameEntity::class], version = 5, exportSchema = false)
@TypeConverters(GameConverterHelper::class)
abstract class GameDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}