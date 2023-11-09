package com.aulia.core.di

import com.aulia.core.data.MovieRepository
import com.aulia.core.domain.repository.ITMovieRespository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 09/11/23
 */

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(movieRepository: MovieRepository): ITMovieRespository
}