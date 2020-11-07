package ru.snowmaze.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.snowmaze.domain.Homework

interface HomeworkRepository {

    fun homework(): Flow<Result<List<Homework>>>

}