package ru.snowmaze.kodetestproject.ui.classes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import ru.snowmaze.domain.Lesson
import ru.snowmaze.kodetestproject.R
import ru.snowmaze.kodetestproject.databinding.FragmentLessonsBinding
import ru.snowmaze.kodetestproject.ui.LessonsAdapterCallback
import ru.snowmaze.kodetestproject.utils.fragmentViewModel
import ru.snowmaze.kodetestproject.utils.openSkype

class LessonsFragment: Fragment(R.layout.fragment_lessons), KodeinAware, LessonsAdapterCallback {

    override val kodein: Kodein by closestKodein()
    private val binding: FragmentLessonsBinding by viewBinding()
    private val viewModel: LessonsViewModel by fragmentViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = LessonsAdapter(requireContext(), this)
        with(binding) {
            recyclerView.adapter = adapter
        }
        viewModel.lessonsLiveData.observe(viewLifecycleOwner) { result ->
            result.fold({
                adapter.lessons = it.toMutableList()
            }) {}
        }
    }

    override fun onSkypeClick(lesson: Lesson) {
        requireContext().openSkype()
    }

}