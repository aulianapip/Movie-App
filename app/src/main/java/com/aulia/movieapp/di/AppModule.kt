package com.aulia.movieapp.di

import com.aulia.core.domain.usecase.MovieInteractor
import com.aulia.core.domain.usecase.MovieUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 09/11/23
 */

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideMovieUseCase(movieInteractor: MovieInteractor) : MovieUseCase
}