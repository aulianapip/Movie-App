package com.aulia.core.utils

import com.aulia.core.data.source.local.entity.MovieEntity
import com.aulia.core.data.source.remote.response.MovieResponse

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 09/11/23
 */
object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map { movieResponse ->

            val movie = MovieEntity(
                movieId = movieResponse.id,
                title = movieResponse.originalTitle,
                voteAverage = movieResponse.voteAverage,
                releaseDate = movieResponse.releaseDate,
                overview = movieResponse.overview,
                posterPath = movieResponse.posterPath,
            )
            movieList.add(movie)
        }
        return movieList
    }

}