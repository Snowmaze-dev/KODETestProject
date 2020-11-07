package ru.snowmaze.data.repository.homework

import ru.snowmaze.data.entity.HomeworkEntity

interface HomeworkSource {

    suspend fun homework(): List<HomeworkEntity>

}