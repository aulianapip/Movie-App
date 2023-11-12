package com.aulia.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 09/11/23
 */


@Entity(tableName = MovieEntity.TABLE_MOVIE)
data class MovieEntity (
    @PrimaryKey(autoGenerate = true)
    val movieId: Int,
    val title: String,
    val voteAverage: Double,
    val releaseDate: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String,
    val originalLanguage: String,
    var isFavorite: Boolean = false

){
    companion object {
        const val TABLE_MOVIE = "tbl_movie"
    }
}

