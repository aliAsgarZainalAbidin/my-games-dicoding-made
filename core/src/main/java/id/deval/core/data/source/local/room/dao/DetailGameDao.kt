package id.deval.core.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import id.deval.core.data.source.local.entity.DetailGameEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

@Dao
interface DetailGameDao {

    @Query("SELECT * FROM detail_game WHERE id = :id")
    fun getDetailGameById(id: String): Flow<DetailGameEntity>

    @Query("SELECT * FROM detail_game")
    fun getDetailGames(): Flow<List<DetailGameEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailGame(detailGameEntity: DetailGameEntity)

    @Delete
    fun deleteDetailGame(detailGameEntity: DetailGameEntity)
}