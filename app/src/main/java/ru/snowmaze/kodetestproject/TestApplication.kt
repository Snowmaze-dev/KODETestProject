package ru.snowmaze.kodetestproject

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import ru.snowmaze.data.entity.HomeworkMapper
import ru.snowmaze.data.repository.homework.HomeworkNetworkSource
import ru.snowmaze.data.repository.homework.HomeworkRepository
import ru.snowmaze.data.repository.homework.HomeworkSource
import ru.snowmaze.data.repository.homework.HomeworkSourceProvider
import ru.snowmaze.data.repository.lessons.LessonsRepository
import ru.snowmaze.data.repository.lessons.LessonsNetworkSource
import ru.snowmaze.data.repository.lessons.LessonsSource
import ru.snowmaze.data.repository.lessons.LessonsSourceProvider
import ru.snowmaze.kodetestproject.ui.home.HomeViewModel
import ru.snowmaze.kodetestproject.utils.bindViewModel

class TestApplication : Application(), KodeinAware {

    override val kodein = Kodein {
        bind<LessonsRepository>() with singleton {
            LessonsRepository(object : LessonsSourceProvider {

                private val lessonsSource: LessonsSource = LessonsNetworkSource()

                override fun lessonsSource() = lessonsSource

            })
        }
        bind<HomeworkRepository>() with singleton {
            HomeworkRepository(object : HomeworkSourceProvider {

                private val homeworkSource: HomeworkSource = HomeworkNetworkSource()

                override fun homeworkSource() = homeworkSource

            }, HomeworkMapper(instance()))
        }
        bindViewModel<HomeViewModel>() with provider {
            HomeViewModel(instance(), instance())
        }
        bind<ViewModelFactory>() with singleton {
            ViewModelFactory(this)
        }
    }

}