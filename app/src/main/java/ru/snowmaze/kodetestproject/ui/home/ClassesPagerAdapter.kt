package ru.snowmaze.kodetestproject.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.snowmaze.data.utils.DateHelper
import ru.snowmaze.domain.Homework
import ru.snowmaze.domain.Lesson
import ru.snowmaze.kodetestproject.databinding.ClassCardBinding

class ClassesPagerAdapter(context: Context): RecyclerView.Adapter<ClassesPagerAdapter.ClassVH>() {

    var classes = mutableListOf<Lesson>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    private val layoutInflater = LayoutInflater.from(context)
    lateinit var callback: ClassesAdapterCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ClassVH(ClassCardBinding.inflate(layoutInflater, parent, false))

    override fun onBindViewHolder(holder: ClassVH, position: Int) {
        holder.bind(classes[position])
    }

    override fun getItemCount() = classes.size

    inner class ClassVH(private val binding: ClassCardBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(c: Lesson) {
            with(binding) {
                className.text = c.name
                classTime.text = DateHelper.today.format(c.time) + " - " + DateHelper.today.format(c.time + c.duration)
                skypeCall.setOnClickListener {
                    callback.onSkypeClick(c)
                }
            }
        }

    }


    interface ClassesAdapterCallback {

        fun onSkypeClick(lesson: Lesson)

    }


}