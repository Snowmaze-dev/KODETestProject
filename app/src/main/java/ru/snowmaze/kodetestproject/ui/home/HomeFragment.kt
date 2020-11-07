package ru.snowmaze.kodetestproject.ui.home

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import ru.snowmaze.domain.Lesson
import ru.snowmaze.kodetestproject.R
import ru.snowmaze.kodetestproject.databinding.FragmentHomeBinding
import ru.snowmaze.kodetestproject.utils.fragmentViewModel
import ru.snowmaze.kodetestproject.utils.showText


class HomeFragment : Fragment(R.layout.fragment_home), KodeinAware,
    ClassesPagerAdapter.ClassesAdapterCallback {

    override val kodein: Kodein by closestKodein()
    private val binding: FragmentHomeBinding by viewBinding()
    private val homeViewModel: HomeViewModel by fragmentViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val classesAdapter = ClassesPagerAdapter(requireContext())
        classesAdapter.callback = this
        val homeworkAdapter = HomeworkPagerAdapter(requireContext())
        with(binding) {
            timerView.timer = 5000
            classes.adapter = classesAdapter
            homework.adapter = homeworkAdapter
            homeViewModel.classesLiveData.observe(viewLifecycleOwner) { result ->
                result.fold({
                    classesAdapter.classes = it.toMutableList()
                    classesToday.text = getString(R.string.classes_today, it.size.toString())
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
        initiateSkypeUri(requireContext())
    }

    private fun initiateSkypeUri(myContext: Context, number: String? = null) {
        if (!isSkypeClientInstalled(myContext)) {
            goToMarket(myContext)
            return
        }

        val skypeUri = number?.let { Uri.parse("skype:$it") }
        val myIntent = Intent(Intent.ACTION_VIEW, skypeUri)

        myIntent.component = ComponentName("com.skype.raider", "com.skype4life.MainActivity")
        myIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        myContext.startActivity(myIntent)
    }

    private fun isSkypeClientInstalled(myContext: Context): Boolean {
        val myPackageMgr: PackageManager = myContext.packageManager
        try {
            myPackageMgr.getPackageInfo("com.skype.raider", PackageManager.GET_ACTIVITIES)
        } catch (e: PackageManager.NameNotFoundException) {
            return false
        }
        return true
    }

    private fun goToMarket(myContext: Context) {
        val marketUri = Uri.parse("market://details?id=com.skype.raider")
        val myIntent = Intent(Intent.ACTION_VIEW, marketUri)
        myIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        myContext.startActivity(myIntent)
    }

}