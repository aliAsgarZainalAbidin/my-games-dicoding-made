package id.deval.core.data.source.local.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import id.deval.core.data.source.local.entity.DetailGameEntity
import id.deval.core.data.source.local.room.converter.GameConverterHelper
import id.deval.core.data.source.local.room.dao.DetailGameDao

@Database(entities = [DetailGameEntity::class], version = 3, exportSchema = false)
@TypeConverters(GameConverterHelper::class)
abstract class DetailGameDatabase : RoomDatabase() {
    abstract fun detailGameDao(): DetailGameDao
}