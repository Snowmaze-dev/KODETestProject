package ru.snowmaze.kodetestproject

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import ru.snowmaze.data.di.dataModule
import ru.snowmaze.kodetestproject.ui.home.HomeViewModel
import ru.snowmaze.kodetestproject.ui.lessons.LessonsViewModel
import ru.snowmaze.kodetestproject.utils.bindViewModel

class TestApplication : Application(), KodeinAware {

    override val kodein = Kodein {
        import(dataModule)
        bindViewModel<HomeViewModel>() with provider {
            HomeViewModel(instance(), instance())
        }
        bindViewModel<LessonsViewModel>() with provider {
            LessonsViewModel(instance())
        }
        bind<ViewModelFactory>() with singleton {
            ViewModelFactory(this)
        }
    }

}