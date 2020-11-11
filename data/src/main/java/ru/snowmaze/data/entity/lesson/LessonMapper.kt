package ru.snowmaze.data.entity.lesson

import ru.snowmaze.data.utils.DateHelper
import ru.snowmaze.domain.Lesson
import java.util.*

class LessonMapper {

    fun mapFromEntity(lesson: LessonEntity) = Lesson(
        lesson.id, lesson.name, lesson.description,
        lesson.teacher, DateHelper.today.parse(lesson.time).time, lesson.duration)

    fun mapToEntity(lesson: Lesson) = LessonEntity(lesson.id, lesson.name, lesson.description, lesson.teacher, DateHelper.today.format(
        Date(lesson.time)
    ), lesson.duration)

}