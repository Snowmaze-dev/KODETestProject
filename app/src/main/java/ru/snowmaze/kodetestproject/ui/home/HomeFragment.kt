package ru.snowmaze.kodetestproject.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import ru.snowmaze.domain.Lesson
import ru.snowmaze.kodetestproject.R
import ru.snowmaze.kodetestproject.databinding.FragmentHomeBinding
import ru.snowmaze.kodetestproject.ui.LessonsAdapterCallback
import ru.snowmaze.kodetestproject.utils.fragmentViewModel
import ru.snowmaze.kodetestproject.utils.openSkype
import ru.snowmaze.kodetestproject.utils.showText

class HomeFragment : Fragment(R.layout.fragment_home), KodeinAware,
    LessonsAdapterCallback {

    override val kodein by closestKodein()
    private val binding: FragmentHomeBinding by viewBinding()
    private val homeViewModel: HomeViewModel by fragmentViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val classesAdapter = LessonsPagerAdapter(requireContext(), this)
        val homeworkAdapter = HomeworkPagerAdapter(requireContext())
        with(binding) {
            timerView.timer = 5000
            classes.adapter = classesAdapter
            homework.adapter = homeworkAdapter
            homeViewModel.lessonsLiveData.observe(viewLifecycleOwner) { result ->
                result.fold({
                    classesAdapter.lessons = it.toMutableList()
                    classesToday.text = getString(R.string.lessons_today, it.size.toString())
                }) {
                    showText(R.string.connection_failed)
                }
            }
        }
        homeViewModel.homeworkLiveData.observe(viewLifecycleOwner) { result ->
            result.onSuccess {
                homeworkAdapter.homework = it.toMutableList()
            }
        }

    }

    override fun onSkypeClick(lesson: Lesson) {
        requireContext().openSkype()
    }

}