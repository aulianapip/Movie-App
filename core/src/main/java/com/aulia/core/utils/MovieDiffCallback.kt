package com.aulia.core.utils

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.aulia.core.domain.model.Movie

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 11/11/23
 */
class MovieDiffCallback(
private val oldList: List<Movie>,
private val newList: List<Movie>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}