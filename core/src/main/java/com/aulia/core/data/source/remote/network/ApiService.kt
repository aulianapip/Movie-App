package com.aulia.core.data.source.remote.network

import androidx.multidex.BuildConfig
import com.aulia.core.data.source.remote.response.ListMovieResponse
import com.aulia.core.data.source.remote.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query
import com.aulia.core.BuildConfig.API_KEY as key

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 09/11/23
 */
interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String = key
    ): ListMovieResponse<MovieResponse>
}