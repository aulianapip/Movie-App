package com.aulia.favorite.di

import android.content.Context
import com.aulia.favorite.FavoriteFragment
import com.aulia.movieapp.di.FavoriteModuleDependencies
import dagger.BindsInstance
import dagger.Component

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 10/11/23
 */
@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteModule {
    fun inject(fragment: FavoriteFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(FavoriteModuleDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteModule
    }
}