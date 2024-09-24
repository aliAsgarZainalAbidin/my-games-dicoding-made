package id.deval.core.data

import id.deval.core.data.source.local.LocalDataSource
import id.deval.core.domain.model.FavoriteGame
import id.deval.core.domain.repository.IFavoriteGameRepository
import id.deval.core.utils.DataMappers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteGameRepository @Inject constructor(
    private val localDataSource: LocalDataSource
) : IFavoriteGameRepository {
    override fun getAllFavoriteGame(): Flow<Resource<List<FavoriteGame>>> =
        object : LocalBoundSource<List<FavoriteGame>>() {
            override fun loadFromDB(): Flow<List<FavoriteGame>> =
                localDataSource.getAllFavoriteGame().map {
                    DataMappers.mapFavoriteEntityToDomain(it)
                }
        }.asFlow()

    override fun getFavoriteGameById(id: String): Flow<Resource<FavoriteGame>> =
        object : LocalBoundSource<FavoriteGame>() {
            override fun loadFromDB(): Flow<FavoriteGame> {
                return localDataSource.getFavoriteGameById(id).map {
                    DataMappers.favoriteGameEntityToDomain(it)
                }
            }

        }.asFlow()

    override fun deleteFavoriteGame(favoriteGame: FavoriteGame) {
        val favoriteGameEntity = DataMappers.favoriteGameDomainToEntity(favoriteGame)
        localDataSource.deleteFavoriteGame(favoriteGameEntity)
    }

}