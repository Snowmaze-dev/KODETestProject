package ru.snowmaze.kodetestproject.ui.classes

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.snowmaze.domain.Lesson
import ru.snowmaze.kodetestproject.databinding.LessonCardBinding
import ru.snowmaze.kodetestproject.ui.LessonVH
import ru.snowmaze.kodetestproject.ui.LessonsAdapterCallback

class LessonsAdapter(context: Context, private val callback: LessonsAdapterCallback) :
    RecyclerView.Adapter<LessonVH>() {

    var lessons = mutableListOf<Lesson>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LessonVH(
        LessonCardBinding.inflate(inflater, parent, false),
        callback
    )

    override fun onBindViewHolder(holder: LessonVH, position: Int) {
        holder.bind(lessons[position])
    }

    override fun getItemCount() = lessons.size

}