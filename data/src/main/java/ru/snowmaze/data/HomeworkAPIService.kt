package ru.snowmaze.data

import retrofit2.http.GET
import ru.snowmaze.data.entity.homework.HomeworkEntity

interface HomeworkAPIService {

    @GET("7093124f-38c9-4fce-8f2a-78a347482880")
    suspend fun getHomework(): List<HomeworkEntity>

}