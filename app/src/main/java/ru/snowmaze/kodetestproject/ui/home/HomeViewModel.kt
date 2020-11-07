package ru.snowmaze.kodetestproject.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import ru.snowmaze.domain.repository.HomeworkRepository
import ru.snowmaze.domain.repository.LessonsRepository

class HomeViewModel(classRepository: LessonsRepository, homeworkRepository: HomeworkRepository): ViewModel() {

    val classesLiveData = classRepository.lessons().asLiveData()
    val homeworkLiveData = homeworkRepository.homework().asLiveData()

}