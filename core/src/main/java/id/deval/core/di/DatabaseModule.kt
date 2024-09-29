package id.deval.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.deval.core.data.source.local.room.dao.DetailGameDao
import id.deval.core.data.source.local.room.dao.FavoriteGameDao
import id.deval.core.data.source.local.room.dao.GameDao
import id.deval.core.data.source.local.room.dao.GenreDao
import id.deval.core.data.source.local.room.db.DetailGameDatabase
import id.deval.core.data.source.local.room.db.FavoriteGameDatabase
import id.deval.core.data.source.local.room.db.GameDatabase
import id.deval.core.data.source.local.room.db.GenreDatabase
import id.deval.core.utils.SecureRoomDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideGameDatabase(@ApplicationContext context: Context): GameDatabase {
        return Room.databaseBuilder(
            context,
            GameDatabase::class.java,
            "Games.db"
        )
            .fallbackToDestructiveMigration()
            .openHelperFactory(SecureRoomDatabase.encryptedRoomDatabase())
            .build()
    }

    @Provides
    fun provideGameDao(database: GameDatabase): GameDao = database.gameDao()

    @Provides
    fun provideDetailGameDao(detailGameDatabase: DetailGameDatabase): DetailGameDao =
        detailGameDatabase.detailGameDao()

    @Singleton
    @Provides
    fun provideDetailGameDatabase(@ApplicationContext context: Context): DetailGameDatabase {
        return Room.databaseBuilder(
            context,
            DetailGameDatabase::class.java,
            "DetailGame.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(SecureRoomDatabase.encryptedRoomDatabase())
            .build()
    }

    @Singleton
    @Provides
    fun provideGenreDatabase(@ApplicationContext context: Context): GenreDatabase {
        return Room.databaseBuilder(
            context,
            GenreDatabase::class.java,
            "Genre.db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideGenreDao(database: GenreDatabase): GenreDao = database.genreDao()

    @Singleton
    @Provides
    fun provideFavoriteGameDatabase(@ApplicationContext context: Context): FavoriteGameDatabase {
        return Room.databaseBuilder(
            context,
            FavoriteGameDatabase::class.java,
            "favoriteGame.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(SecureRoomDatabase.encryptedRoomDatabase())
            .build()
    }

    @Provides
    fun provideFavoriteGameDao(database: FavoriteGameDatabase): FavoriteGameDao =
        database.favoriteGameDao()
}