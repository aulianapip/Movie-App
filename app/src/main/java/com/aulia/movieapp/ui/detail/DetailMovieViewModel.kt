package com.aulia.movieapp.ui.detail

import androidx.lifecycle.ViewModel
import com.aulia.core.domain.model.Movie
import com.aulia.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 10/11/23
 */
@HiltViewModel
class DetailMovieViewModel @Inject constructor(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoriteMovie(movie: Movie, newStatus:Boolean) =
        movieUseCase.setFavoriteMovie(movie, newStatus)
}