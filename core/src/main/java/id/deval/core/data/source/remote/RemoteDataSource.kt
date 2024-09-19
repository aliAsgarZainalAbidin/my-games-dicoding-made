package id.deval.core.data.source.remote

import android.util.Log
import id.deval.core.data.source.remote.network.ApiResponse
import id.deval.core.data.source.remote.network.ApiService
import id.deval.core.data.source.remote.response.DetailGameResponse
import id.deval.core.data.source.remote.response.GameResponse
import id.deval.core.data.source.remote.response.GenreResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    companion object {
        const val TAG = "RemoteDataSource"
    }

    suspend fun getAllGames(): Flow<ApiResponse<List<GameResponse>>> {
        return flow {
            try {
                val response = apiService.getGames(1,20)
                val games = response.results
                if (games?.isNotEmpty() == true) {
                    emit(ApiResponse.Success(games))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e(TAG, "getAllGames: $e")
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getGenres(): Flow<ApiResponse<List<GenreResponse>>> {
        return flow {
            try {
                val response = apiService.getGenres()
                val genres = response.results
                if (genres?.isNotEmpty() == true) {
                    emit(ApiResponse.Success(genres))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e(TAG, "getGenres: $e")
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getDetailGame(id: String): Flow<ApiResponse<DetailGameResponse>> {
        return flow {
            try {
                val detailGame = apiService.getDetailGame(id)
                if (detailGame != null){
                    emit(ApiResponse.Success(detailGame))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e(TAG, "getDetailGame: $e")
            }
        }.flowOn(Dispatchers.IO)
    }
}
