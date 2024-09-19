package id.deval.core.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import id.deval.core.data.source.local.entity.GenreEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

@Dao
interface GenreDao {

    @Query("SELECT * FROM genres")
    fun getAllGenres(): Flow<List<GenreEntity>>

    @Query("SELECT * FROM genres WHERE id = :id")
    fun getGenreById(id: Int): Flow<GenreEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenres(genres: List<GenreEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenre(genre: GenreEntity)

    @Delete
    fun deleteGenre(genre: GenreEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateGenre(genre: GenreEntity)

}