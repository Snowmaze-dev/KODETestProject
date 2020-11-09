package ru.snowmaze.data.entity.homework

import ru.snowmaze.data.repository.lessons.LessonsRepository
import ru.snowmaze.data.utils.DateHelper
import ru.snowmaze.domain.Homework
import java.io.IOException
import java.util.*

class HomeworkMapper(
    private val lessonsRepository: LessonsRepository,
) {

    suspend fun mapFromEntity(homework: HomeworkEntity) = Homework(
        homework.id.toInt(),
        lessonsRepository.lesson(homework.lessonId.toInt()) ?: throw IOException(),
        DateHelper.dayFormat.parse(homework.expireTime).time,
        homework.task
    )

    suspend fun mapToEntity(homework: Homework) =
        HomeworkEntity(homework.id.toString(), homework.lesson.id.toString(), DateHelper.dayFormat.format(Date(homework.expireTime)), homework.task)

}