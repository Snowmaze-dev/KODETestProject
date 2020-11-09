package ru.snowmaze.kodetestproject.ui.lessons

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.vipulasri.timelineview.TimelineView
import ru.snowmaze.data.utils.time
import ru.snowmaze.domain.Lesson
import ru.snowmaze.kodetestproject.databinding.CardWithTimelineBinding
import ru.snowmaze.kodetestproject.ui.LessonsAdapterCallback

class LessonsAdapter(context: Context, private val callback: LessonsAdapterCallback) :
    RecyclerView.Adapter<LessonsAdapter.LessonVH>() {

    var lessons = mutableListOf<Lesson>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LessonVH(
        CardWithTimelineBinding.inflate(inflater, parent, false), callback)

    override fun onBindViewHolder(holder: LessonVH, position: Int) {
        holder.bind(lessons[position])
    }

    override fun getItemCount() = lessons.size

    override fun getItemViewType(position: Int) = TimelineView.getTimeLineViewType(position, itemCount)

    class LessonVH(private val binding: CardWithTimelineBinding, private val callback: LessonsAdapterCallback): RecyclerView.ViewHolder(binding.root) {

        fun bind(lesson: Lesson) {
            binding.timeline.initLine(itemViewType)
            binding.time.text = lesson.time()
            with(binding.lessonCard) {
                lessonName.text = lesson.name
                lessonDescription.text = lesson.description
                skypeCall.setOnClickListener {
                    callback.onSkypeClick(lesson)
                }
            }
        }
    }

}