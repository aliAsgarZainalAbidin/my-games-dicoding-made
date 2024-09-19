package id.deval.core.domain.usecase

import id.deval.core.data.Resource
import id.deval.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameUseCase {
    fun getAllGame(): Flow<Resource<List<Game>>>
//    fun getFavoriteGame(): Flow<List<Game>>
//    fun setFavoriteGame(game: Game, state: Boolean)
}