package com.aulia.core.domain.usecase

import com.aulia.core.domain.model.Movie
import com.aulia.core.domain.repository.ITMovieRespository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 09/11/23
 */
class MovieInteractor @Inject constructor(private val movieRepository: ITMovieRespository): MovieUseCase{

    override fun getPopularMovie() = movieRepository.getPopularMovie()

    override fun getFavoriteMovie() = movieRepository.getFavoriteMovie()

    override fun setFavoriteMovie(movie: Movie, state: Boolean) = movieRepository.setFavoriteMovie(movie, state)
    override fun searchMovie(value: String): Flow<List<Movie>> = movieRepository.searchMovie(value)

}