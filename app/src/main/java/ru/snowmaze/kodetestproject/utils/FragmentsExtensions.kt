package ru.snowmaze.kodetestproject.utils

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.showText(text: String, length: Int = Snackbar.LENGTH_SHORT) =
    view?.let { Snackbar.make(it, text, length).show() }

fun Fragment.showText(@StringRes resId: Int, length: Int = Snackbar.LENGTH_SHORT) =
    showText(getString(resId), length)