package ru.snowmaze.data

import retrofit2.http.GET
import ru.snowmaze.data.entity.homework.HomeworkEntity

interface HomeworkAPIService {

    @GET("get_homework.php")
    suspend fun getHomework(): List<HomeworkEntity>

}