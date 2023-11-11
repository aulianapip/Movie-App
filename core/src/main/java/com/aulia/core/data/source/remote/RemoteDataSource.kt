package com.aulia.core.data.source.remote

import android.util.Log
import com.aulia.core.data.source.remote.network.ApiResponse
import com.aulia.core.data.source.remote.network.ApiService
import com.aulia.core.data.source.remote.response.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 09/11/23
 */

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getPopularMovie(): Flow<ApiResponse<List<MovieResponse>>> {
        return flow {
            try {
                val response = apiService.getPopularMovie()
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}