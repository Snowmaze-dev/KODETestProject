package ru.snowmaze.data.repository.lessons

import kotlinx.coroutines.flow.flow
import ru.snowmaze.data.entity.lesson.LessonMapper
import ru.snowmaze.domain.repository.LessonsRepository
import java.io.IOException

class LessonsRepository(private val lessonsSourceProvider: LessonsSourceProvider, private val lessonMapper: LessonMapper) :
    LessonsRepository {

    override fun lessons() = flow {
        val lessons = try {
             lessonsSourceProvider.lessonsSource().lessons()
        }
        catch (e: IOException) {
            emit(Result.failure(e))
            return@flow
        }
        emit(Result.success(lessons.map(lessonMapper::mapFromEntity)))
    }

    override suspend fun lesson(id: Int) = try {
        lessonsSourceProvider.lessonsSource().lesson(id)?.let {
            lessonMapper.mapFromEntity(it)
        }
    }
    catch (e: IOException) {
        null
    }

}