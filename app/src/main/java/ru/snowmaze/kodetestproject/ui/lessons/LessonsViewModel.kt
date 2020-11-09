package ru.snowmaze.kodetestproject.ui.lessons

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import ru.snowmaze.domain.Lesson
import ru.snowmaze.domain.repository.LessonsRepository

class LessonsViewModel(private val lessonsRepository: LessonsRepository) : ViewModel() {

    val lessonsLiveData: LiveData<Result<List<Lesson>>>
        get() = lessonsRepository.lessons().asLiveData()

}