package com.aulia.core.data

import com.aulia.core.data.source.local.LocalDataSource
import com.aulia.core.data.source.remote.RemoteDataSource
import com.aulia.core.data.source.remote.network.ApiResponse
import com.aulia.core.data.source.remote.response.MovieResponse
import com.aulia.core.domain.model.Movie
import com.aulia.core.domain.repository.ITMovieRespository
import com.aulia.core.utils.AppExecutors
import com.aulia.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 09/11/23
 */

@Singleton
class MovieRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ITMovieRespository {

    override fun getPopularMovie(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getPopularMovie().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean =
//                data == null || data.isEmpty()
            true

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getPopularMovie()


            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
            }
        }.asFlow()

}