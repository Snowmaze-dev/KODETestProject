package ru.snowmaze.data.repository.lessons

import kotlinx.coroutines.flow.flow
import ru.snowmaze.domain.Lesson
import ru.snowmaze.domain.repository.LessonsRepository

class LessonsRepository(private val lessonsSourceProvider: LessonsSourceProvider) :
    LessonsRepository {

    override fun lessons() = flow<Result<List<Lesson>>> {
        emit(Result.success(lessonsSourceProvider.lessonsSource().lessons()))
    }

    override fun lesson(id: Int) = flow<Result<Lesson>> {
        emit(lessonsSourceProvider.lessonsSource().lesson(id)?.let { Result.success(it) }
            ?: Result.failure(RuntimeException("This lesson doesn't exist")))
    }

}