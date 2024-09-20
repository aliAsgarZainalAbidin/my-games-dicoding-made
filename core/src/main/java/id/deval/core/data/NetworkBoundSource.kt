package id.deval.core.data

import id.deval.core.data.source.remote.network.ApiResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

abstract class NetworkBoundSource<ResultType,RequestType> {

    private var result : Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        val loadResources = loadFromDB().first()

        if(shouldFetch(loadResources)){
            emit(Resource.Loading())
            when(val request = createCall().first()){
                is ApiResponse.Success -> {
                    CoroutineScope(Dispatchers.IO).launch {
                        saveCallResult(request.data)
                    }
                    emitAll(loadFromDB().map { Resource.Success(it) })
                }

                is ApiResponse.Empty -> {
                    emitAll(loadFromDB().map { Resource.Success(it) })
                }

                is ApiResponse.Error -> {
                    onFetchFailed()
                    emit(Resource.Error(request.errorMessage))
                }
            }
        } else {
            emitAll(loadFromDB().map { Resource.Success(it) })
        }

    }

    protected open fun onFetchFailed(){}

    protected abstract fun loadFromDB() : Flow<ResultType>

    protected abstract fun shouldFetch(data : ResultType?) : Boolean

    protected abstract suspend fun createCall() : Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data : RequestType)

    fun asFlow() : Flow<Resource<ResultType>> = result

}