package ru.snowmaze.kodetestproject.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import ru.snowmaze.domain.Homework
import ru.snowmaze.domain.Lesson
import ru.snowmaze.domain.repository.HomeworkRepository
import ru.snowmaze.domain.repository.LessonsRepository

class HomeViewModel(
    private val lessonsRepository: LessonsRepository,
    private val homeworkRepository: HomeworkRepository
) : ViewModel() {

    val lessonsLiveData: LiveData<Result<List<Lesson>>>
        get() = lessonsRepository.lessons().asLiveData()
    val homeworkLiveData: LiveData<Result<List<Homework>>>
        get() = homeworkRepository.homework().asLiveData()
}