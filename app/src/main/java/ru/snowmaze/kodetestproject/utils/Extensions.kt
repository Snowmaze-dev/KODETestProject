package ru.snowmaze.kodetestproject.utils

import android.content.res.Resources

fun Int.dp() = this * Resources.getSystem().displayMetrics.density