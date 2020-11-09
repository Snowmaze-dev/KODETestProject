package ru.snowmaze.data.repository.lessons

import ru.snowmaze.data.entity.lesson.LessonEntity

interface LessonsSource {

    suspend fun lessons(): List<LessonEntity>

    suspend fun lesson(id: Int): LessonEntity?

}