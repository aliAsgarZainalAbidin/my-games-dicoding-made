package id.deval.core.utils

import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory

object SecureRoomDatabase {
    fun encryptedRoomDatabase() = SupportFactory(SQLiteDatabase.getBytes("made-dicoding".toCharArray()))
}