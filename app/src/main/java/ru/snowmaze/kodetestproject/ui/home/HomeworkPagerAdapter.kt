package ru.snowmaze.kodetestproject.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.snowmaze.domain.Homework
import ru.snowmaze.kodetestproject.databinding.HomeworkCardBinding

class HomeworkPagerAdapter(context: Context) :
    RecyclerView.Adapter<HomeworkPagerAdapter.ClassVH>() {

    var homework = mutableListOf<Homework>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ClassVH(HomeworkCardBinding.inflate(layoutInflater, parent, false))

    override fun onBindViewHolder(holder: ClassVH, position: Int) {
        holder.bind(homework[position])
    }

    override fun getItemCount() = homework.size

    class ClassVH(private val binding: HomeworkCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(homework: Homework) {
            with(binding) {
                lessonAndTime.text = homework.lesson.name
                task.text = homework.task
            }
        }
    }


}