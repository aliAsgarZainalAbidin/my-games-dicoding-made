package id.deval.favorite.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.deval.core.domain.usecase.FavoriteGameUsecase
import id.deval.favorite.ui.FavoriteGameViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val getFavoriteGameUsecase : FavoriteGameUsecase
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(FavoriteGameViewModel::class.java) -> FavoriteGameViewModel(getFavoriteGameUsecase) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}