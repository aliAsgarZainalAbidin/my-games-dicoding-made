package id.deval.mygames.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.deval.core.data.Resource
import id.deval.core.domain.model.Game
import id.deval.core.domain.model.Genre
import id.deval.core.domain.usecase.GameUseCase
import id.deval.core.utils.launchCatchError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private var gameUseCase: GameUseCase) : ViewModel() {

    companion object {
        const val TAG = "HomeViewModel"
    }

    var games = gameUseCase.getAllGame(arrayListOf()).asLiveData(viewModelScope.coroutineContext)

}