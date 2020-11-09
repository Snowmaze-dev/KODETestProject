package ru.snowmaze.data.repository.homework

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import ru.snowmaze.data.HomeworkAPIService

class HomeworkNetworkSource(retrofit: Retrofit) : HomeworkSource {

    private val service = retrofit.create(HomeworkAPIService::class.java)

    override suspend fun homework() = withContext(Dispatchers.IO) {
        service.getHomework()
    }

}