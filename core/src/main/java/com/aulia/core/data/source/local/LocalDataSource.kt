package com.aulia.core.data.source.local

import com.aulia.core.data.source.local.entity.MovieEntity
import com.aulia.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 09/11/23
 */
@Singleton
class LocalDataSource @Inject constructor(private val movieDao: MovieDao) {

    fun getPopularMovie(): Flow<List<MovieEntity>> = movieDao.getPopularMovie()

    fun getFavoriteMovie(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovie()

    suspend fun insertMovie(movieList: List<MovieEntity>) = movieDao.insertMovie(movieList)

    fun setFavoriteTourism(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updateFavoriteMovie(movie)
    }
    fun searchMovie(value: String): Flow<List<MovieEntity>> = movieDao.searchMovies(value)
}