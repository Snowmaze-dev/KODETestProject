package ru.snowmaze.kodetestproject.ui

import ru.snowmaze.domain.Lesson

interface LessonsAdapterCallback {

    fun onSkypeClick(lesson: Lesson)

}