package id.deval.core.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

abstract class LocalBoundSource<ResultType> {

    private val result : Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        emitAll(loadFromDB().map { Resource.Success(it) })
    }

    protected abstract fun loadFromDB() : Flow<ResultType>

    fun asFlow() : Flow<Resource<ResultType>> = result
}