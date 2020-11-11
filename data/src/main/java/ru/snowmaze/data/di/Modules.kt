package ru.snowmaze.data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import ru.snowmaze.data.entity.homework.HomeworkMapper
import ru.snowmaze.data.entity.lesson.LessonMapper
import ru.snowmaze.data.repository.homework.HomeworkNetworkSource
import ru.snowmaze.data.repository.homework.HomeworkRepository
import ru.snowmaze.data.repository.homework.HomeworkSource
import ru.snowmaze.data.repository.homework.HomeworkSourceProvider
import ru.snowmaze.data.repository.lessons.LessonsNetworkSource
import ru.snowmaze.data.repository.lessons.LessonsRepository
import ru.snowmaze.data.repository.lessons.LessonsSource
import ru.snowmaze.data.repository.lessons.LessonsSourceProvider

val dataModule = Kodein.Module("DataModule") {
    bind<Retrofit>() with singleton {
        val contentType = "application/json".toMediaType()
        Retrofit.Builder().baseUrl("http://snowmaze.fvds.ru/kode/")
            .addConverterFactory(Json{
                ignoreUnknownKeys = true
            }.asConverterFactory(contentType)).build()
    }
    bind<LessonsRepository>() with singleton {
        LessonsRepository(object : LessonsSourceProvider {

            private val lessonsSource: LessonsSource = LessonsNetworkSource(instance())

            override fun lessonsSource() = lessonsSource

        }, LessonMapper())
    }
    bind<HomeworkRepository>() with singleton {
        HomeworkRepository(object : HomeworkSourceProvider {

            private val homeworkSource: HomeworkSource = HomeworkNetworkSource(instance())

            override fun homeworkSource() = homeworkSource

        }, HomeworkMapper(instance()))
    }
}