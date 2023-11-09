package com.aulia.movieapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.aulia.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 09/11/23
 */
@HiltViewModel
class HomeViewModel @Inject constructor(movieUseCase: MovieUseCase) : ViewModel(){
    val movie = movieUseCase.getPopularMovie().asLiveData()
}