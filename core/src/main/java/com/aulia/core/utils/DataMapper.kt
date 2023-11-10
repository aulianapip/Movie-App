package com.aulia.core.utils

import com.aulia.core.data.source.local.entity.MovieEntity
import com.aulia.core.data.source.remote.response.MovieResponse
import com.aulia.core.domain.model.Movie

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
                title = movieResponse.title,
                voteAverage = movieResponse.voteAverage,
                releaseDate = movieResponse.releaseDate,
                overview = movieResponse.overview,
                posterPath = movieResponse.posterPath,
                backdropPath = movieResponse.backdropPath,
                originalLanguage = movieResponse.originalLanguage,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>) : List<Movie> =
        input.map {
            Movie(
                id = it.movieId,
                title = it.title,
                voteAverage = it.voteAverage,
                releaseDate = it.releaseDate,
                overview = it.overview,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                originalLanguage = it.originalLanguage,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) =
        MovieEntity(
            movieId = input.id,
            title = input.title,
            voteAverage = input.voteAverage,
            releaseDate = input.releaseDate,
            overview = input.overview,
            posterPath = input.posterPath,
            backdropPath = input.backdropPath,
            originalLanguage = input.originalLanguage,
            isFavorite = input.isFavorite
        )

}