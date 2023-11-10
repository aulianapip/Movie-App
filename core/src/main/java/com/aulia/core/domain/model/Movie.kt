package com.aulia.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 09/11/23
 */
@Parcelize
data class Movie(
    val overview: String,
    val title: String,
    val posterPath: String,
    val releaseDate: String,
    val voteAverage: Double,
    val id: Int,
    val backdropPath: String,
    val originalLanguage: String,
    val isFavorite: Boolean
) : Parcelable
