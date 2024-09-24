package id.deval.core.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.deval.core.data.source.local.entity.FavoriteGameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteGameDao {
    @Query("SELECT * FROM favorite_game")
    fun getAllFavoriteGame() : Flow<List<FavoriteGameEntity>>

    @Query("SELECT * FROM favorite_game WHERE id = :id")
    fun getFavoriteGameById(id : String) : Flow<FavoriteGameEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteGame(game : FavoriteGameEntity)

    @Delete
    fun deleteFavoriteGame(game: FavoriteGameEntity)
}