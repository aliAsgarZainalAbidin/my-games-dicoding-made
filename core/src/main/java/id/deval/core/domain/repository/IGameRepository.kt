package id.deval.core.domain.repository

import id.deval.core.data.Resource
import id.deval.core.domain.model.DetailGame
import id.deval.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface IGameRepository {

    fun getAllGames() : Flow<Resource<List<Game>>>

    fun getDetailGame(id : String) : Flow<Resource<DetailGame>>

//    fun getFavoriteGame() : Flow<List<Game>>

    fun deleteGame(game: Game)

    fun setFavoriteGame(game: Game, state : Boolean)
}