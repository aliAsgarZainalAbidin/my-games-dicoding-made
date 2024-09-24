package id.deval.core.data.source.local

import id.deval.core.data.source.local.entity.DetailGameEntity
import id.deval.core.data.source.local.entity.FavoriteGameEntity
import id.deval.core.data.source.local.entity.GameEntity
import id.deval.core.data.source.local.entity.GenreEntity
import id.deval.core.data.source.local.room.dao.DetailGameDao
import id.deval.core.data.source.local.room.dao.FavoriteGameDao
import id.deval.core.data.source.local.room.dao.GameDao
import id.deval.core.data.source.local.room.dao.GenreDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val gameDao: GameDao,
    private val genreDao: GenreDao,
    private val favoriteGameDao: FavoriteGameDao,
    private val detailGameDao: DetailGameDao
) {

    fun getAllGames() = gameDao.getAllGames()

    fun getAllGenres() = genreDao.getAllGenres()

    fun getGameById(id: String) = gameDao.getGameById(id)

    fun getGenreById(id: Int) = genreDao.getGenreById(id)

    fun insertGames(games: List<GameEntity>) = gameDao.insertGames(games)

    fun insertGenres(genres: List<GenreEntity>) = genreDao.insertGenres(genres)

    fun insertGame(game: GameEntity) = gameDao.insertGame(game)

    fun insertGenre(genre: GenreEntity) = genreDao.insertGenre(genre)

    fun deleteGame(game: GameEntity) = gameDao.deleteGame(game)

    fun deleteGenre(genre: GenreEntity) = genreDao.deleteGenre(genre)

    fun updateGame(game: GameEntity) = gameDao.updateGame(game)

    fun updateGenre(genre: GenreEntity) = genreDao.updateGenre(genre)

    fun getDetailGameById(id: String) = detailGameDao.getDetailGameById(id)

    fun insertDetailGame(detailGameEntity: DetailGameEntity) = detailGameDao.insertDetailGame(detailGameEntity)

    fun getAllFavoriteGame() = favoriteGameDao.getAllFavoriteGame()

    fun getFavoriteGameById(id: String) = favoriteGameDao.getFavoriteGameById(id)

    fun deleteFavoriteGame(favoriteGame: FavoriteGameEntity) = favoriteGameDao.deleteFavoriteGame(favoriteGame)
}