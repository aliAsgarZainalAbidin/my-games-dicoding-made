package id.deval.core.domain.usecase

import id.deval.core.data.Resource
import id.deval.core.domain.model.FavoriteGame
import id.deval.core.domain.repository.IFavoriteGameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteGameInteractor @Inject constructor(
    private val favoriteGameRepository: IFavoriteGameRepository
) : FavoriteGameUsecase {
    override fun getAllFavoriteGame(): Flow<Resource<List<FavoriteGame>>> =
        favoriteGameRepository.getAllFavoriteGame()

    override fun deleteFavoriteGame(favoriteGame: FavoriteGame) =
        favoriteGameRepository.deleteFavoriteGame(favoriteGame)

    override fun getFavoriteGameById(id: String): Flow<Resource<FavoriteGame>> =
        favoriteGameRepository.getFavoriteGameById(id)
}