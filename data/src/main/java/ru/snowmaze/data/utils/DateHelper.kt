package ru.snowmaze.data.utils

import java.text.SimpleDateFormat
import java.util.*

object DateHelper {

    val dayFormat = SimpleDateFormat("dd-MM-yyyy", Locale.ROOT)

    val dateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ROOT)

    val today = SimpleDateFormat("HH:mm", Locale.ROOT)


}