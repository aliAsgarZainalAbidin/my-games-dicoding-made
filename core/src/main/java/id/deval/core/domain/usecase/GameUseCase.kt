package id.deval.core.domain.usecase

import id.deval.core.data.Resource
import id.deval.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameUseCase {
    fun getAllGame(genres : ArrayList<String>): Flow<Resource<List<Game>>>
}