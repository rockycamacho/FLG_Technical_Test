package com.rockycamacho.diversify.test.presentation.exercises.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.rockycamacho.diversify.test.R
import com.rockycamacho.diversify.test.data.network.models.Exercise
import com.rockycamacho.diversify.test.di.AppComponent
import com.rockycamacho.diversify.test.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_exercises_list.list
import kotlinx.android.synthetic.main.fragment_exercises_view.*

class ExercisesViewFragment : BaseFragment<ExercisesViewViewModel>() {

    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    private val adapter = MuscleListAdapter()

    override fun getLayoutResId(): Int = R.layout.fragment_exercises_view

    companion object {
        fun newInstance(exercise: Exercise): ExercisesViewFragment {
            val fragment = ExercisesViewFragment()
            fragment.arguments = Bundle().apply {
                putParcelable("exercise", exercise)
            }
            return fragment
        }
    }

    override fun getViewModelClass(): Class<ExercisesViewViewModel> = ExercisesViewViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.layoutManager = LinearLayoutManager(requireContext())
        list.setHasFixedSize(true)

        list.adapter = adapter
        var exercise = arguments?.getParcelable<Exercise>("exercise")
        viewModel.show(exercise!!)
        viewModel.getExercise().observe(this, Observer {

            name.text = exercise.name
            Glide.with(this@ExercisesViewFragment)
                .load(exercise.imageUrl)
                .into(image)
            description.text = exercise.description
            adapter.submitList(it.targetMuscles)
        })
    }

}