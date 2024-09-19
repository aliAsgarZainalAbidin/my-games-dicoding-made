package id.deval.core.data.source.remote.network

import id.deval.core.data.source.remote.response.DetailGameResponse
import id.deval.core.data.source.remote.response.ListGameResponse
import id.deval.core.data.source.remote.response.ListGenreResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("games")
    suspend fun getGames(
        @Query("page") page : Int? = null,
        @Query("page_size") pageSize : Int? = null,
    ): ListGameResponse

    @GET("genres")
    suspend fun getGenres(
        @Query("page") page : Int? = null,
        @Query("page_size") pageSize : Int? = null,
    ): ListGenreResponse


    @GET("games/{id}")
    suspend fun getDetailGame(
        @Path("id") id : String,
    ): DetailGameResponse?
}