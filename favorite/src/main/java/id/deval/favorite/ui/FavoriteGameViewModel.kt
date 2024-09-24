package id.deval.favorite.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import id.deval.core.domain.model.FavoriteGame
import id.deval.core.domain.usecase.FavoriteGameUsecase
import javax.inject.Inject

@HiltViewModel
class FavoriteGameViewModel @Inject constructor(
    private val favoriteGameUsecase: FavoriteGameUsecase
) : ViewModel() {

    val favoriteGames = favoriteGameUsecase.getAllFavoriteGame().asLiveData()

    fun getFavoriteGameById(id : String) = favoriteGameUsecase.getFavoriteGameById(id).asLiveData()

    fun deleteFavoriteGame(favoriteGame: FavoriteGame) = favoriteGameUsecase.deleteFavoriteGame(favoriteGame)
}