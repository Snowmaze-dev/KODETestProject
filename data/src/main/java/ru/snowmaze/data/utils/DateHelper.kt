package ru.snowmaze.data.utils

import java.text.SimpleDateFormat
import java.util.*

object DateHelper {

    val dayFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ROOT)

    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT)

    val today = SimpleDateFormat("HH:mm", Locale.ROOT)


}