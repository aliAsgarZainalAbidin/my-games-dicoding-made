package id.deval.core.domain.usecase

import id.deval.core.data.Resource
import id.deval.core.domain.model.Game
import id.deval.core.domain.repository.IGameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameInteractor @Inject constructor(private val gameRepository: IGameRepository) : GameUseCase {
    override fun getAllGame(genres : ArrayList<String>): Flow<Resource<List<Game>>> {
        return gameRepository.getAllGames(genres)
    }
}