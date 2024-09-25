package id.deval.mygames.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.deval.core.domain.model.Game
import id.deval.core.domain.usecase.FavoriteGameUsecase
import id.deval.core.domain.usecase.GameUseCase
import id.deval.core.utils.launchCatchError
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val favoriteUseCase: FavoriteGameUsecase
) : ViewModel() {

    companion object {
        const val TAG = "DetailViewModel"
    }

    fun setFavoriteGame(game: Game) {
        viewModelScope.launchCatchError(
            Dispatchers.IO,
            block = {
                favoriteUseCase.setFavoriteGame(game)
            },
            onError = {
                Log.d(TAG, "setFavoriteGame: $it")
            }
        )
    }

    fun deleteFromFavorite(game: Game) {
        viewModelScope.launchCatchError(
            Dispatchers.IO,
            block = {
                favoriteUseCase.deleteFavoriteGame(game)
            },
            onError = {
                Log.d(TAG, "deleteFromFavorite: $it")
            }
        )
    }

    fun getAllFavoriteGame() = favoriteUseCase.getAllFavoriteGame().asLiveData()
}