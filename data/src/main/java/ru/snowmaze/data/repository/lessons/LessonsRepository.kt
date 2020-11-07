package ru.snowmaze.data.repository.lessons

import kotlinx.coroutines.flow.flow
import ru.snowmaze.domain.Lesson
import ru.snowmaze.domain.repository.LessonsRepository

class LessonsRepository(private val lessonsSourceProvider: LessonsSourceProvider) :
    LessonsRepository {

    override fun lessons() = flow<Result<List<Lesson>>> {
        emit(Result.success(lessonsSourceProvider.lessonsSource().lessons()))
    }

    override suspend fun lesson(id: Int) = lessonsSourceProvider.lessonsSource().lesson(id)

}