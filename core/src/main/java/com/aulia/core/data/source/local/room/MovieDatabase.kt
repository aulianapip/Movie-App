package com.aulia.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aulia.core.data.source.local.entity.MovieEntity

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 09/11/23
 */
@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}