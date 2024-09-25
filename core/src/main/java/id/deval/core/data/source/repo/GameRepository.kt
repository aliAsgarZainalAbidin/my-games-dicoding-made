package id.deval.core.data.source.repo

import id.deval.core.data.NetworkBoundSource
import id.deval.core.data.Resource
import id.deval.core.data.source.local.LocalDataSource
import id.deval.core.data.source.remote.RemoteDataSource
import id.deval.core.data.source.remote.network.ApiResponse
import id.deval.core.data.source.remote.response.DetailGameResponse
import id.deval.core.data.source.remote.response.GameResponse
import id.deval.core.domain.model.DetailGame
import id.deval.core.domain.model.Game
import id.deval.core.domain.repository.IGameRepository
import id.deval.core.utils.DataMappers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : IGameRepository {
    override fun getAllGames(genre: ArrayList<String>): Flow<Resource<List<Game>>> =
        object : NetworkBoundSource<List<Game>, List<GameResponse>>() {
            override fun loadFromDB(): Flow<List<Game>> {
                return localDataSource.getAllGames().map {
                    DataMappers.mapGameEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<GameResponse>>> {
                return remoteDataSource.getAllGames()
            }

            override suspend fun saveCallResult(data: List<GameResponse>) {
                val gameList = DataMappers.mapGameResponsesToEntities(data)
                localDataSource.insertGames(gameList)
            }

            override fun shouldFetch(data: List<Game>?): Boolean {
                return true
            }

        }.asFlow()

    override fun getDetailGame(id: String): Flow<Resource<DetailGame>> =
        object : NetworkBoundSource<DetailGame, DetailGameResponse>() {
            override fun shouldFetch(data: DetailGame?) = true

            override fun loadFromDB(): Flow<DetailGame> {
                return localDataSource.getDetailGameById(id).map {
                    DataMappers.mapDetailGameEntityToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<DetailGameResponse>> {
                return remoteDataSource.getDetailGame(id)
            }

            override suspend fun saveCallResult(data: DetailGameResponse) {
                return localDataSource.insertDetailGame(DataMappers.mapDetailGameResponseToEntity(data))
            }

        }.asFlow()

    override fun deleteGame(game: Game) {
        TODO("Not yet implemented")
    }

}