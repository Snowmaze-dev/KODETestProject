package ru.snowmaze.kodetestproject.ui

import androidx.recyclerview.widget.RecyclerView
import ru.snowmaze.data.utils.time
import ru.snowmaze.domain.Lesson
import ru.snowmaze.kodetestproject.databinding.LessonCardBinding

class LessonVH(private val binding: LessonCardBinding, private val callback: LessonsAdapterCallback) : RecyclerView.ViewHolder(binding.root) {

    fun bind(lesson: Lesson) {
        with(binding) {
            lessonName.text = lesson.name
            lessonTime.text = lesson.time()
            skypeCall.setOnClickListener {
                callback.onSkypeClick(lesson)
            }
        }
    }

}

interface LessonsAdapterCallback {

    fun onSkypeClick(lesson: Lesson)

}