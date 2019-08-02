package com.rockycamacho.diversify.test.presentation.exercises.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rockycamacho.diversify.test.R
import com.rockycamacho.diversify.test.di.AppComponent
import com.rockycamacho.diversify.test.presentation.base.BaseFragment
import com.rockycamacho.diversify.test.presentation.exercises.view.ExercisesViewFragment
import kotlinx.android.synthetic.main.fragment_exercises_list.*

class ExercisesListFragment : BaseFragment<ExercisesListViewModel>() {

    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    override fun getLayoutResId(): Int = R.layout.fragment_exercises_list

    companion object {
        fun newInstance(): ExercisesListFragment {
            return ExercisesListFragment()
        }
    }

    override fun getViewModelClass(): Class<ExercisesListViewModel> = ExercisesListViewModel::class.java

    private val adapter = ExerciseListAdapter { exercise ->
        requireFragmentManager().beginTransaction()
            .replace(
                R.id.fragment_container,
                ExercisesViewFragment.newInstance(exercise)
            )
            .addToBackStack(
                ExercisesViewFragment::class.java.simpleName
            )
            .commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.layoutManager = LinearLayoutManager(requireContext())
        list.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        list.setHasFixedSize(true)

        list.adapter = adapter

        viewModel.getData().observe(this, Observer {
            if(it.isEmpty()) {
                empty.visibility = View.VISIBLE
            }
            else {
                empty.visibility = View.GONE
            }
            adapter.submitList(it)
        })
        viewModel.getErrorMessage().observe(this, Observer {
            if(it.isNotEmpty()) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.fetchData()
    }

}