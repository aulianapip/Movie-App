package com.aulia.core.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * @author Aulianapip
 * email: naufalapip45@gmail.com
 * on 10/11/23
 */
object Utils {

    fun String.toDateFormatYear(): String =
        try {
            val df = SimpleDateFormat("yyyy-MM-dd", Locale.US)
            val date = df.parse(this) as Date
            SimpleDateFormat("yyyy", Locale.US).format(date)
        } catch (e: Exception) {
            "-"
        }
}