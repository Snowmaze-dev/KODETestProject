package ru.snowmaze.data.repository.homework

import ru.snowmaze.data.entity.homework.HomeworkEntity

interface HomeworkSource {

    suspend fun homework(): List<HomeworkEntity>

}