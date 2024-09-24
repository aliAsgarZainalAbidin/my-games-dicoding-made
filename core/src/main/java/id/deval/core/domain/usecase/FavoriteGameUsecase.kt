package id.deval.core.domain.usecase

import id.deval.core.data.Resource
import id.deval.core.domain.model.FavoriteGame
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Singleton
interface FavoriteGameUsecase {
    fun getAllFavoriteGame() : Flow<Resource<List<FavoriteGame>>>
    fun deleteFavoriteGame(favoriteGame: FavoriteGame)
    fun getFavoriteGameById(id : String) : Flow<Resource<FavoriteGame>>
}