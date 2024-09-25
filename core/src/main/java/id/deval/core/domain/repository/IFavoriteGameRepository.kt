package id.deval.core.domain.repository

import id.deval.core.data.Resource
import id.deval.core.domain.model.FavoriteGame
import id.deval.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface IFavoriteGameRepository {
    fun getAllFavoriteGame() : Flow<Resource<List<FavoriteGame>>>

    fun getFavoriteGameById(id : String) : Flow<Resource<FavoriteGame>>

    fun deleteFavoriteGame(game: Game)

    fun setFavoriteGame(game: Game)
}