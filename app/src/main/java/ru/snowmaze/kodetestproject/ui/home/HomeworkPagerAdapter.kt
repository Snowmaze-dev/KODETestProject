package ru.snowmaze.kodetestproject.ui.home

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.TextViewCompat
import androidx.recyclerview.widget.RecyclerView
import ru.snowmaze.domain.Homework
import ru.snowmaze.kodetestproject.R
import ru.snowmaze.kodetestproject.databinding.HomeworkCardBinding
import java.util.*
import java.util.concurrent.TimeUnit

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
                lessonName.text = homework.lesson.name
                task.text = homework.task
                val daysLeft = TimeUnit.MILLISECONDS.toDays(homework.expireTime - Date().time)
                lessonTime.text = root.context.getString(
                    R.string.homework_days_left,
                    daysLeft.toString()
                )
                val color = if (daysLeft <= 2) Color.RED else Color.GRAY
                lessonTime.setTextColor(color)
                TextViewCompat.setCompoundDrawableTintList(
                    lessonTime,
                    ColorStateList(arrayOf(intArrayOf()), intArrayOf(color))
                )
            }
        }
    }
}
