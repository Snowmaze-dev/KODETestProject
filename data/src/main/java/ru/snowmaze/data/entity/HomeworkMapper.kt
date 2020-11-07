package ru.snowmaze.data.entity

import kotlinx.coroutines.flow.first
import ru.snowmaze.data.repository.lessons.LessonsRepository
import ru.snowmaze.domain.Homework

class HomeworkMapper(private val lessonsRepository: LessonsRepository) {
    
    suspend fun mapFromEntity(homework: HomeworkEntity) = Homework(homework.id, lessonsRepository.lesson(homework.lessonId).first().getOrThrow(), homework.expireTime, homework.task)

    suspend fun mapToEntity(homework: Homework) = HomeworkEntity(homework.id, homework.lesson.id, homework.expireTime, homework.task)

}