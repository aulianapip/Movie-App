package com.aulia.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.aulia.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 09/11/23
 */
@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getPopularMovie(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie where isFavorite = 1")
    fun getFavoriteMovie(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: List<MovieEntity>)

    @Update
    fun updateFavoriteMovie(movie: MovieEntity)
}