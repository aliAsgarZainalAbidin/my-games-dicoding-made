package id.deval.core.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import id.deval.core.data.source.local.entity.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Query("SELECT * FROM games")
    fun getAllGames() : Flow<List<GameEntity>>

    @Query("SELECT * FROM games WHERE id = :id")
    fun getGameById(id : String) : Flow<GameEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGames(games : List<GameEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGame(game : GameEntity)

    @Delete
    fun deleteGame(game : GameEntity)

    @Update
    fun updateGame(game : GameEntity)
}