package ru.snowmaze.data.repository.homework

import kotlinx.coroutines.flow.flow
import ru.snowmaze.data.entity.HomeworkMapper
import ru.snowmaze.domain.repository.HomeworkRepository

class HomeworkRepository(
    private val homeworkSourceProvider: HomeworkSourceProvider,
    private val mapper: HomeworkMapper
) : HomeworkRepository {

    override fun homework() = flow {
        emit(Result.success(homeworkSourceProvider.homeworkSource().homework().map {
            mapper.mapFromEntity(it)
        }))
    }

}