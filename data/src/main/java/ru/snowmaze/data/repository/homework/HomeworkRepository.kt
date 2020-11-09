package ru.snowmaze.data.repository.homework

import kotlinx.coroutines.flow.flow
import ru.snowmaze.data.entity.homework.HomeworkMapper
import ru.snowmaze.domain.repository.HomeworkRepository
import java.io.IOException

class HomeworkRepository(
    private val homeworkSourceProvider: HomeworkSourceProvider,
    private val mapper: HomeworkMapper
) : HomeworkRepository {

    override fun homework() = flow {
        val homework = try {
            homeworkSourceProvider.homeworkSource().homework()
        }
        catch (e: IOException) {
            emit(Result.failure(e))
            return@flow
        }
        emit(Result.success(homework.map {
            mapper.mapFromEntity(it)
        }))
    }

}