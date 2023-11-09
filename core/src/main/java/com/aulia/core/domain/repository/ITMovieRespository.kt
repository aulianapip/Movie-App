package com.aulia.core.domain.repository

import com.aulia.core.data.Resource
import com.aulia.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 09/11/23
 */
interface ITMovieRespository {

    fun getPopularMovie(): Flow<Resource<List<Movie>>>
}