package ru.snowmaze.data.entity.lesson

import ru.snowmaze.data.utils.DateHelper
import ru.snowmaze.domain.Lesson
import java.util.*

class LessonMapper {

    fun mapFromEntity(lesson: LessonEntity) = Lesson(lesson.id.toInt(), lesson.name, lesson.description,
        lesson.teacher, DateHelper.today.parse(lesson.time).time, DateHelper.today.parse(lesson.duration).time.toInt()
    )

    fun mapToEntity(lesson: Lesson) = LessonEntity(lesson.id.toString(), lesson.name, lesson.description, lesson.teacher, DateHelper.today.format(
        Date(lesson.time)
    ), DateHelper.today.format(Date(lesson.duration.toLong())))

}