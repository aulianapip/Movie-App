package com.aulia.core.domain.usecase

import com.aulia.core.data.Resource
import com.aulia.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 09/11/23
 */
interface MovieUseCase {
    fun getPopularMovie(): Flow<Resource<List<Movie>>>
}