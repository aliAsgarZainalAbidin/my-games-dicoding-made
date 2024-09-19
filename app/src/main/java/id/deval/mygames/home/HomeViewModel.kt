package id.deval.mygames.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import id.deval.core.domain.usecase.GameUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(gameUseCase : GameUseCase) : ViewModel() {

    val games = gameUseCase.getAllGame().asLiveData()

}