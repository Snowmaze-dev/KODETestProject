package ru.snowmaze.kodetestproject.utils

import android.content.res.ColorStateList
import android.widget.TextView
import androidx.core.widget.TextViewCompat

fun TextView.setCompoundDrawableTint(color: Int) {
    TextViewCompat.setCompoundDrawableTintList(
        this,
        ColorStateList(arrayOf(intArrayOf()), intArrayOf(color))
    )
}