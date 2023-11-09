package com.aulia.core.domain.usecase

import com.aulia.core.domain.repository.ITMovieRespository
import javax.inject.Inject

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 09/11/23
 */
class MovieInteractor @Inject constructor(private val movieRepository: ITMovieRespository): MovieUseCase{

    override fun getPopularMovie() = movieRepository.getPopularMovie()


}