package ru.snowmaze.data.repository.lessons

import ru.snowmaze.data.utils.DateHelper
import ru.snowmaze.domain.Lesson

class LessonsNetworkSource: LessonsSource {

    private val lessons = listOf(Lesson(1, "Math", DateHelper.today.parse("08:00").time), Lesson(2, "Physics", DateHelper.today.parse("8:55").time))

    override suspend fun lesson(id: Int): Lesson? { // TODO
        for(lesson in lessons) {
            if(lesson.id == id) return lesson
        }
        return null
    }

    override suspend fun lessons() = lessons // TODO

}