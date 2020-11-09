package ru.snowmaze.data

import retrofit2.http.GET
import retrofit2.http.Path
import ru.snowmaze.data.entity.lesson.LessonEntity

interface LessonsAPIService {

    @GET("6e82d28a-b094-4db0-88ca-1ca1d480a186")
    suspend fun getLessons(): List<LessonEntity>

    @GET("6e82d28a-b094-4db0-88ca-1ca1d480a186/{lesson_id}")
    suspend fun getLesson(@Path(value = "lesson_id", encoded = true) id: Int): List<LessonEntity> // Потому, что этот сайт выдаёт List на запрос по айди


}