package id.deval.mygames.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.deval.core.domain.model.Game
import id.deval.core.domain.usecase.GameUseCase
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val gameUseCase: GameUseCase
) : ViewModel() {

}