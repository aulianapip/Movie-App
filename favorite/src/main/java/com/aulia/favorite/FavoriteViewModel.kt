package com.aulia.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.aulia.core.domain.usecase.MovieUseCase

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 10/11/23
 */
class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val moviesFavorite = movieUseCase.getFavoriteMovie().asLiveData()
}