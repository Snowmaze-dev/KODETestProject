package ru.snowmaze.data.repository.lessons

import ru.snowmaze.domain.Lesson

interface LessonsSource {

    suspend fun lessons(): List<Lesson>

    suspend fun lesson(id: Int): Lesson?

}