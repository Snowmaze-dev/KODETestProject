package ru.snowmaze.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.snowmaze.domain.Lesson

interface LessonsRepository {

    fun lessons(): Flow<Result<List<Lesson>>>

    fun lesson(id: Int): Flow<Result<Lesson>>

}