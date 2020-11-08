package ru.snowmaze.kodetestproject.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.recyclerview.widget.RecyclerView
import ru.snowmaze.domain.Lesson
import ru.snowmaze.kodetestproject.databinding.LessonCardBinding
import ru.snowmaze.kodetestproject.ui.LessonVH
import ru.snowmaze.kodetestproject.ui.LessonsAdapterCallback

class LessonsPagerAdapter(context: Context, private val callback: LessonsAdapterCallback) :
    RecyclerView.Adapter<LessonVH>() {

    var lessons = mutableListOf<Lesson>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LessonVH(
            LessonCardBinding.inflate(layoutInflater, parent, false).apply {
                val lp = root.layoutParams
                lp.height = MATCH_PARENT
                root.layoutParams = lp
            }, callback
        )

    override fun onBindViewHolder(holder: LessonVH, position: Int) {
        holder.bind(lessons[position])
    }

    override fun getItemCount() = lessons.size


}