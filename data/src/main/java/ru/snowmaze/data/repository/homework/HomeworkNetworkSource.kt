package ru.snowmaze.data.repository.homework

import ru.snowmaze.data.entity.HomeworkEntity
import ru.snowmaze.data.repository.utils.DateHelper

class HomeworkNetworkSource : HomeworkSource {

    private val homework = listOf(
        HomeworkEntity(1, 1, DateHelper.dayFormat.parse("12-11-2020").time, "Calc 2 * 2^6+6"),
        HomeworkEntity(2, 1, DateHelper.dayFormat.parse("15-11-2020").time, "task task task task"),
        HomeworkEntity(3, 2, DateHelper.dayFormat.parse("13-11-2020").time, "task task task task"),
    )

    override suspend fun homework() = homework // TODO

}