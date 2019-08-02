package com.rockycamacho.diversify.test.presentation.exercises.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rockycamacho.diversify.test.R
import com.rockycamacho.diversify.test.data.network.models.Exercise

class ExerciseListAdapter(private val clickListener: (Exercise) -> Unit) : ListAdapter<Exercise, ExerciseViewHolder>(ExerciseItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ExerciseViewHolder(inflater.inflate(R.layout.item_exercise, parent, false))
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

}
